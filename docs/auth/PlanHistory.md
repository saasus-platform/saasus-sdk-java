

# PlanHistory


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**planId** | **String** |  |  |
|**planAppliedAt** | **Integer** | 登録日時 |  |
|**taxRateId** | **String** |  |  [optional] |
|**prorationBehavior** | **ProrationBehavior** |  |  [optional] |
|**deleteUsage** | **Boolean** | stripe連携している場合で、プラン変更時に従量課金アイテムを削除するか設定できます。 プラン変更した場合に、現在のサブスクリプションに含まれる従量課金アイテムを全て削除して、従量課金アイテムに基づく請求の発生を止めることができます。 即時に記録している使用量がクリアされます。それらは復元できないため、delete_usageをtrueにしたプラン変更予約は取り消しできません。  If you have a stripe linkage,  you can set whether to delete pay-as-you-go items when changing plans. When you change plan, you can remove all pay-as-you-go items included in your current subscription to stop being billed based on pay-as-you-go items. The recorded usage is cleared immediately. Since it cannot be restored, please note that plan change reservations with delete_usage set to true cannot be canceled.  |  [optional] |



