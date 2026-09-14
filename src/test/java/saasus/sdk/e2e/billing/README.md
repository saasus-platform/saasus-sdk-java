# billing E2E

Stripe 連携情報 API (`StripeApi`) の E2E テスト。共通の実行方法・環境変数は
[../README.md](../README.md) を参照。

## メソッド (×4 スタイル)

- `getStripeInfo`
- `updateStripeInfo`
- `deleteStripeInfo`

## ストーリー

Go 参考実装と同じ CRUD フローを 4 スタイルそれぞれで実行します:

`Pre_Get → Update → Get(確認) → Delete → Final_Get`

## 環境変数

- 必須: `SAASUS_SAAS_ID` / `SAASUS_API_KEY` / `SAASUS_SECRET_KEY`
- 任意: `STRIPE_SECRET_KEY`（更新に使う値。未設定時はテスト用プレースホルダ）

## 実行

```bash
mvn verify -Pe2e -Dit.test=BillingApiE2ETest
```
