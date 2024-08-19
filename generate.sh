#!/bin/bash

# 生成するモジュール名の配列
MODULES="auth pricing billing awsmarketplace integration apilog communication"

# sdkに含まれる生成したプログラムを削除
SDK_SRC_DIR="src/main/java/saasus/sdk"
SDK_TEST_DIR="src/test/java/saasus/sdk"

# 削除対象ディレクトリ
DELETE_DIRS="generated"

for module in ${MODULES}
do
    if [ -d ${SDK_SRC_DIR}/${module} ]; then
        rm -rf ${SDK_SRC_DIR}/${module}
        echo "delete ${SDK_SRC_DIR}/${module} success"
    fi
    if [ -d ${SDK_TEST_DIR}/${module} ]; then
        rm -rf ${SDK_TEST_DIR}/${module}
        echo "delete ${SDK_TEST_DIR}/${module} success"
    fi
done

# javadocを削除
rm -rf ./docs/*
echo "delete javadoc success"

for dir in ${DELETE_DIRS}
do
    if [ -d ./${dir} ]; then
        rm -rf ./${dir}
    fi
done

#Javaクラスを生成
for module in ${MODULES}
do
    if [ "${module}" = "integration" ]; then
        target="/local/${module}.yml"
    else
        target="/local/${module}api.yml"
    fi

    docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli:v7.2.0 generate \
    -i ${target} \
    -g java \
    --additional-properties=modelPackage=saasus.sdk.${module}.models,apiPackage=saasus.sdk.${module}.api \
    -o /local/generated/${module} \
    --additional-properties useOneOfDiscriminatorLookup=true,disallowAdditionalPropertiesIfNotPresent=false
done

for module in ${MODULES}
do
    # プログラム
    cp -pr "generated/${module}/${SDK_SRC_DIR}/${module}" "${SDK_SRC_DIR}/${module}"
    # テストケース
    cp -pr "generated/${module}/${SDK_TEST_DIR}/${module}" "${SDK_TEST_DIR}/${module}"
    # javadoc
    mkdir -p "docs/${module}" && cp -p generated/${module}/docs/* "docs/${module}/"
    echo "copy ${module} success"
done

# discriminatorの判定でエラーになるため、上書きする
cp -p PricingUnit.java ${SDK_SRC_DIR}/pricing/models/PricingUnit.java
cp -p PricingUnitForSave.java ${SDK_SRC_DIR}/pricing/models/PricingUnitForSave.java

# 生成したプログラムを削除
rm -rf ./generated
echo "delete generated success"
