# Java 用カスタムテンプレート（openapi-generator v7.2.0）

`oneof_model.mustache` は openapi-generator v7.2.0 の
`Java/libraries/okhttp-gson/oneof_model.mustache` をそのまま取り込み、
`validateJsonElement` に discriminator による判定を追加したもの。

生成コードの `validateJsonElement` は本来 oneOf の全 variant を検証し、
構造一致がちょうど1件であることを要求する。`PricingUnit` のように同じ構造を持つ
variant があると複数一致で失敗するため、discriminator で1件に絞ってから検証する。

ここに置いていないテンプレートは openapi-generator 同梱のものが使われる。
`generate.sh` の generator バージョンを上げる際は、新しいバージョンの
`oneof_model.mustache` を取り直して同じ変更を当て直すこと。
