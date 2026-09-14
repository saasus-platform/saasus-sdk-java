# pricing E2E

料金 API (Metering / PricingUnits / PricingMenus / PricingPlans / TaxRate) の E2E テスト。
共通の実行方法・環境変数は [../README.md](../README.md) を参照。

## カバレッジ (30 メソッド ×4 スタイル)

Go 参考実装 (`GetPricingMethods`) と同じ範囲を対象にします。
個別 Delete（`deletePricingUnit/Menu/Plan`, `deleteMeteringUnitByID`）、`linkPlanToStripe`、
`deleteStripePlan` は Go と同様に **対象外**（依存/ Stripe 制約のため）。後片付けは
`deleteAllPlansAndMenusAndUnitsAndMetersAndTaxRates` を使用します。

- Metering: create/get/update(byID) + timestamp count(update/now/delete) + 日次/月次集計取得
- PricingUnit: create(固定ユニット)/get/getList/update
- PricingMenu: create/get/getList/update
- PricingPlan: create/get/getList/update + updatePricingPlansUsed
- TaxRate: create/getList/update
- 初期化: deleteAll...

## ストーリー

依存順（メーター → ユニット → メニュー → プラン → 税率）で作成・取得・更新し、
テナント別の集計取得を行い、最後に `deleteAll...` で後片付けします。
これを 4 スタイルそれぞれで実行します。エンティティ名は実行ごとにユニーク化されます。

## 環境変数

- 必須: `SAASUS_SAAS_ID` / `SAASUS_API_KEY` / `SAASUS_SECRET_KEY`
- 必須(集計系): `TEST_TENANT_ID` … テナント別集計メソッドが実在テナントを必要とします
  （テスト内でテナントは作成しません）。

## 実行

```bash
mvn verify -Pe2e -Dit.test=PricingApiE2ETest
```
