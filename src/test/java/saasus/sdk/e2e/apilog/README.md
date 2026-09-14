# apilog E2E

API 実行ログ API (`ApiLogApi`) の E2E テスト。共通の実行方法・環境変数は
[../README.md](../README.md) を参照。

## メソッド (×4 スタイル)

- `getLogs`
- `getLog`

## ストーリー

Go 参考実装と同じフローを 4 スタイルそれぞれで実行します:

`Pre_GetApiLogs(id等を抽出) → GetApiLogs → GetApiLogs With QueryParameters → GetApiLog`

`GetApiLogs With QueryParameters` では、先行ステップで取得した
`created_date` / `created_at` / `cursor` をクエリに使用します。

## 対象外

Postman コレクションの `range-search`（`start_at` / `end_at` による範囲検索・排他エラー系）は、
Java SDK が該当パラメータを公開していないため対象外です。

## 環境変数

- 必須: `SAASUS_SAAS_ID` / `SAASUS_API_KEY` / `SAASUS_SECRET_KEY`

## 実行

```bash
mvn verify -Pe2e -Dit.test=ApiLogApiE2ETest
```
