#!/bin/bash

# バージョン引数がある場合のみ pom.xml を更新
if [ $# -ge 1 ]; then
  RAW_VERSION=$1
  CLEAN_VERSION=${RAW_VERSION#v}
  echo "Target SDK version: ${CLEAN_VERSION}"

  # sh 互換のバージョン形式チェック（例: 1.2.3, 1.2.3rc1, 1.2.3-beta.1）
  echo "$CLEAN_VERSION" | grep -Eq '^[0-9]+\.[0-9]+\.[0-9]+([a-zA-Z0-9.-]*)?$'
  if [ $? -ne 0 ]; then
    echo "Invalid version format: ${CLEAN_VERSION}. Skipping version update."
  else
    echo "Updating pom.xml version to ${CLEAN_VERSION}"

    awk -v v="$CLEAN_VERSION" '
      BEGIN { replaced = 0 }
      /<version>.*<\/version>/ && replaced == 0 {
        sub(/<version>.*<\/version>/, "<version>" v "</version>")
        replaced = 1
      }
      { print }
    ' pom.xml > pom.tmp && mv pom.tmp pom.xml

    echo "Updated pom.xml version to ${CLEAN_VERSION}"
  fi
else
  echo "No version argument provided, skipping version update"
fi

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
    --additional-properties useOneOfDiscriminatorLookup=true \
    --template-dir /local/templates/openapi-generator/java-v7-2-0//libraries/okhttp-gson/
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

# 生成したプログラムを削除
rm -rf ./generated
echo "delete generated success"
