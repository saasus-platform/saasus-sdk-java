# testlib - 共通テストライブラリ

**SaaSus SDK Java 用共通テストライブラリ** — 全 API モジュールで再利用できる E2E テスト基盤です。
Java 8 互換・追加依存なし（Gson は SDK 既存依存）で提供します。

配置先: `src/test/java/saasus/sdk/testlib`

## 設計方針（重要）

各 API モジュール（billing / pricing / auth / ...）は、それぞれ独立した
`ApiClient` / `ApiException` / `ApiResponse<T>` / `ApiCallback<T>` を持ち、共通の親型がありません。
そのため testlib は**特定モジュールに依存しません**。SDK の呼び出し方はすべて
**関数型インターフェース + メソッドレジストリ**で表現し、モジュール固有の型変換は
呼び出し側のラムダに閉じ込めます。`src/main/java`（SDK 本体）は一切変更しません。

## パッケージ構成

```
testlib/
├── TestStatus / LogLevel / CallStyle    # 列挙型
├── Config / EnvFileLoader / SnapshotConfig  # 設定（.env 自前パーサ、依存追加なし）
├── Masker / Logger                      # 機密情報マスキング付きログ
├── NormalCall / HttpInfoCall / SinkCall # 4 呼び出しスタイルの関数型IF
├── AsyncSink / LatchAsyncSink           # 非同期コールバックの受け皿
├── HttpInfo / ApiError / ApiErrorExtractor  # 共通DTO・例外抽出
├── ExecutionResult                      # 共通結果型
├── MethodInvokers(+Builder) / MethodRegistry # メソッドレジストリ
├── StatusValidator                      # ステータス検証
├── MethodExecutor                       # 4スタイルの実行→共通結果へ変換
├── Validation / StateUpdate / LifecycleAction  # Step/Story 用の関数型IF
├── Step(+Builder) / Story(+Builder)     # ストーリー定義
├── StepResult / StoryResult / MethodExecution
├── CoverageTracker                      # (method:style) 単位のカバレッジ
├── Reporter                             # summary / detailed / JSON
├── E2EEngine                            # 実行エンジン（timeout/retry/fail-fast/dry-run）
├── StoryObserver                        # story 完了フック（snapshot 連携）
└── snapshot/
    ├── CompatibilityLevel / CompatibilityIssue / ComparisonResult
    ├── SnapshotMetadata / StepSnapshot / StorySnapshot   # Go 構造・snake_case・RFC3339/ナノ秒
    ├── SdkReturnValue / HttpResponseSnapshot / SdkMethodError   # 戻り値・HTTP 情報・エラー
    ├── StoryExecutionSummary / SkippedStepInfo           # 実行サマリ
    ├── SnapshotMasker                   # 機密キーを [MASKED len=N] にマスク（実値は保持）
    ├── SnapshotJson                     # snake_case Gson / キー昇順ソート / body 整形
    ├── SnapshotComparator               # Breaking/Warning 分類（git タグ間比較）
    ├── SnapshotFileManager              # 保存/読込・git タグ別配置・検証ファイル入出力
    ├── SnapshotValidator                # ストーリー検証（completion/sequence/state-transition）
    ├── ValidationError / ValidationComparison / ValidationSummary / StoryValidation  # 検証結果モデル
    ├── SnapshotReporter                 # console / JSON / Markdown
    └── SnapshotEngine                   # capture → 保存/比較/検証 → レポート
```

## 設定

### 環境変数

```bash
# 必須
SAASUS_SAAS_ID=your-saas-id
SAASUS_API_KEY=your-api-key
SAASUS_SECRET_KEY=your-secret-key

# 任意
SAASUS_API_URL_BASE=https://api.saasus.io   # SDK 署名層・クライアントが参照するエンドポイント
LOG_LEVEL=debug            # debug / info / warn / error
E2E_LOG_LEVEL=debug        # LOG_LEVEL を上書き（E2E 専用）
E2E_DRY_RUN=true
E2E_TIMEOUT=300            # 秒（story 単位のタイムアウト）
E2E_MAX_RETRIES=3
E2E_FAIL_FAST=true

# スナップショット（いずれか設定時のみ Config.snapshot が有効化される）
E2E_SNAPSHOT_ENABLE=true         # capture 有効
E2E_SNAPSHOT_COMPARISON=true     # 前回タグと比較
E2E_SNAPSHOT_REPORTING=true      # 比較結果を出力
E2E_SNAPSHOT_OUTPUT_DIR=tests/e2e/snapshot
E2E_SNAPSHOT_CAPTURE_LEVEL=FULL  # FULL / MINIMAL
```

`.env` は実行時のカレントディレクトリから上位数階層まで自動探索されます
（`.env`, `../.env`, ... `../../../../.env`）。実プロセスの環境変数が `.env` より優先されます。
**`.env` は開発時の利便機能で、CI などで実環境変数を設定すれば不要です。**

> **重要**: SDK 本体の署名処理・クライアント設定（`Utils.withSaasusSigV1` / 各モジュールの `Configuration`）は
> `SAASUS_SAAS_ID` / `SAASUS_API_KEY` / `SAASUS_SECRET_KEY` / `SAASUS_API_URL_BASE` を
> **実プロセスの環境変数（`System.getenv()`）から直接読み取ります**。Java からはプロセス環境変数を
> 書き換えられないため、これら 4 つは `.env` だけに書いても SDK には渡りません。そのため testlib は
> これらを `.env` のみの値としては「未設定」とみなし（`Config.validate()` で早期にエラー）、実行前に
> 実環境変数へ export しておく必要があります。その他の `E2E_*` などの設定は `.env` で指定できます。

### コマンドライン引数

`-Dtestlib.args="..."` で渡せます（`--verbose` / `--dry-run` / `--fail-fast` / `--timeout <秒>`）。

```bash
mvn test -Dtestlib.args="--verbose --dry-run"
```

## 基本的な使い方

```java
import saasus.sdk.testlib.*;
import saasus.sdk.billing.api.StripeApi;
import saasus.sdk.billing.ApiResponse;
import saasus.sdk.billing.ApiCallback;
import saasus.sdk.billing.models.StripeInfo;
import saasus.sdk.modules.BillingApiClient;

// 1) 設定（環境変数 + .env + args）
Config config = Config.fromEnv();
config.validate(); // 必須環境変数チェック

// 2) 署名付きクライアントと API
BillingApiClient client = new BillingApiClient();
StripeApi api = new StripeApi(client);

// 3) メソッドレジストリ（4 スタイルを登録）
MethodRegistry registry = new MethodRegistry();
registry.register("getStripeInfo", MethodInvokers.builder()
    // 通常メソッド：戻り値のみ（HTTP ステータス/ヘッダーは未設定扱い）
    .normal(vars -> api.getStripeInfo())
    // *WithHttpInfo：モジュール固有 ApiResponse<T> を共通 HttpInfo へ変換
    .withHttpInfo(vars -> {
        ApiResponse<StripeInfo> r = api.getStripeInfoWithHttpInfo();
        return new HttpInfo(r.getData(), r.getStatusCode(), r.getHeaders());
    })
    // *Async：モジュール固有 ApiCallback<T> を AsyncSink に橋渡し
    .async((vars, sink) -> api.getStripeInfoAsync(new ApiCallback<StripeInfo>() {
        public void onSuccess(StripeInfo r, int code, java.util.Map<String, java.util.List<String>> h) {
            sink.onSuccess(r, code, h);
        }
        public void onFailure(saasus.sdk.billing.ApiException e, int code, java.util.Map<String, java.util.List<String>> h) {
            sink.onFailure(e, code, h);
        }
        public void onUploadProgress(long a, long b, boolean d) {}
        public void onDownloadProgress(long a, long b, boolean d) {}
    }))
    // *Call：*Call メソッドは okhttp3.Call を組み立てて返すだけで実行しない。
    //        設定済み(署名付き) ApiClient 経由で実際に実行し、結果を sink へ橋渡しする。
    .call((vars, sink) -> {
        okhttp3.Call httpCall = api.getStripeInfoCall(null);
        try {
            ApiResponse<StripeInfo> r = client.execute(httpCall, StripeInfo.class);
            sink.onSuccess(r.getData(), r.getStatusCode(), r.getHeaders());
        } catch (saasus.sdk.billing.ApiException e) {
            sink.onFailure(e, e.getCode(), e.getResponseHeaders());
        }
    })
    .build());

// 4) 各モジュールの ApiException を共通 ApiError へ変換する抽出関数（モジュールに1つ）
ApiErrorExtractor errorExtractor = ex -> {
    if (ex instanceof saasus.sdk.billing.ApiException) {
        saasus.sdk.billing.ApiException e = (saasus.sdk.billing.ApiException) ex;
        return new ApiError(e.getCode(), e.getResponseHeaders(), e.getResponseBody());
    }
    return null;
};

// 5) エンジン作成
E2EEngine engine = new E2EEngine(registry, config, errorExtractor);
```

## Story / Step の定義

```java
Story story = Story.builder("Stripe 連携情報 CRUD")
    .description("Stripe 情報の取得を 4 スタイルで検証")
    .module("billing")
    .setup(vars -> { /* 事前準備。vars に値を入れて後続 step へ渡せる */ })
    .step(Step.builder("取得(通常)", "getStripeInfo")
        .callStyle(CallStyle.NORMAL)
        .validation(response -> {
            if (response == null) throw new AssertionError("response is null");
        })
        // レスポンスから値を取り出し、後続の step へ引き継ぐ
        .stateUpdate((response, vars) -> vars.put("stripeInfo", response))
        .build())
    .step(Step.builder("取得(WithHttpInfo)", "getStripeInfo")
        .callStyle(CallStyle.WITH_HTTP_INFO)
        .expectedStatus(200)               // 期待ステータス（省略時は 2xx を許容）
        .build())
    .step(Step.builder("取得(Async)", "getStripeInfo")
        .callStyle(CallStyle.ASYNC)
        .allowedStatuses(200, 404)         // 許容ステータス一覧（expectedStatus より優先）
        .build())
    .step(Step.builder("取得(Call)", "getStripeInfo")
        .callStyle(CallStyle.CALL)
        .expectedStatus(200)
        .build())
    .cleanup(vars -> { /* 失敗時も必ず実行される後片付け */ })
    .build();

java.util.List<StoryResult> results = engine.executeStories(
        java.util.Collections.singletonList(story));

engine.printResults(results);          // サマリ + カバレッジ
String json = engine.jsonReport(results); // JSON レポート
```

### 検証・カバレッジ

- ステータス検証は **期待値 → 許容値一覧 → デフォルト 2xx** の順で解決されます。
  通常メソッド（`NORMAL`）は HTTP ステータスを取得できないため未設定として扱われ、検証はスキップされます。
- カバレッジは登録した **(メソッド名 : 呼び出しスタイル)** 単位で集計され、未テストの組み合わせを検出できます。

### 実行制御

- **タイムアウト**: `Story.timeoutSeconds(n)`（未指定時は `Config.timeout`）。超過した step は失敗になります。
- **リトライ**: 通信エラー / タイムアウト / HTTP 429 / 5xx を `Config.maxRetries` 回まで線形バックオフで再試行します。
- **Fail-fast**: `E2E_FAIL_FAST=true` で、失敗した story の後続 story を実行しません。
- **Dry-run**: `E2E_DRY_RUN=true` で実際の呼び出しを行わず、カバレッジのみ記録します。

## スナップショット

```java
import saasus.sdk.testlib.snapshot.*;

SnapshotConfig sc = new SnapshotConfig();
sc.enableCapture = true;      // スナップショット保存
sc.enableComparison = true;   // 前回タグと比較
sc.enableReporting = true;    // 比較結果を出力
sc.outputDirectory = "tests/e2e/snapshot/billing";

// 機密値はキー名ベースで [MASKED len=N] にマスク。id / 日時などの動的値は実値のまま保存し、
// 実行ごとの差異は git タグ別ファイルで区別する（saasus-sdk-go と同じ方式）。
SnapshotMasker masker = new SnapshotMasker();

SnapshotEngine snapshot = new SnapshotEngine(sc, engine.logger(), masker);
engine.addObserver(snapshot); // story 完了ごとに capture → 保存/比較/検証 → レポート
```

出力は saasus-sdk-go と同じレイアウトで、`<outputDirectory>` 配下に生成されます:

- スナップショット: `story_snapshots/tags/story_snapshot_{gitタグ}_{story}.json`
- 検証ファイル: `story_validations/story_validation_{story}_{gitタグ}.json`（直近 2 世代を保持）

git タグは `git describe --tags --exact-match HEAD` → `--tags --always` →
`snapshot_<epoch>` の順で解決され、比較は **異なるタグ間** の同一 story に対して行われます
（同一タグの再実行は上書き）。差分は次のように分類されます:

| 変更内容 | 分類 |
|----------|------|
| story 名 / status 変更・メソッド名変更・ステータスコード変更・戻り値の型変更・成否変更・戻り値削除・step 置換 | **Breaking** |
| json_data / body / ヘッダー変更・step 追加/削除・step 数変更・戻り値追加 | **Warning** |

比較時、動的ヘッダー（`Date` / `X-Saasus-Trace-Id` など）は無視されます。
比較結果は `SnapshotReporter` で **コンソール / JSON / Markdown** に出力できます。
機密情報（API キー・シークレット・トークン・パスワード・認可ヘッダー等）はキー名ベースで
自動マスクされ、`[MASKED len=N]`（N=元の長さ）に置換されます。動的フィールド（id・日時など）は
実値のまま保存されます。

検証（`SnapshotValidator`）は各 story の完了・step 順序・状態遷移をチェックし、結果を
`story_validations/` に出力します（completion / sequence は error、state-transition は warning、
timing は無効）。

## 実行

```bash
# 全テスト
mvn test

# 詳細ログ
LOG_LEVEL=debug mvn test
```

> **注記**: 本ライブラリは共通基盤です。各モジュール（billing / pricing / auth / ...）の
> 具体的なストーリーとテスト本体は、本 Issue とは別に追加されます。
