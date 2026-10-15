#!/bin/bash

# どの工程が失敗しても即座に非ゼロ終了する（生成に失敗したまま
# 後続のコピーやビルドに進ませない）。
set -eu

# バージョン引数がある場合のみ pom.xml を更新
if [ $# -ge 1 ]; then
  RAW_VERSION=$1
  CLEAN_VERSION=${RAW_VERSION#v}
  echo "Target SDK version: ${CLEAN_VERSION}"

  # sh 互換のバージョン形式チェック（例: 1.2.3, 1.2.3rc1, 1.2.3-beta.1）
  if echo "$CLEAN_VERSION" | grep -Eq '^[0-9]+\.[0-9]+\.[0-9]+([a-zA-Z0-9.-]*)?$'; then
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
  else
    echo "Invalid version format: ${CLEAN_VERSION}. Skipping version update."
  fi
else
  echo "No version argument provided, skipping version update"
fi

# 生成するモジュール名の配列
MODULES="auth pricing billing awsmarketplace integration apilog communication"

# OpenAPI spec の置き場所。既定はリポジトリ直下。
SPEC_DIR="${SPEC_DIR:-.}"

# モジュール名から spec ファイルを解決する。ここが唯一の変換規則で、
# 正規化済みの <module>.yml（fetch-openapi-spec アクションの出力、
# integration も同形）を優先し、無ければ従来の <module>api.yml を使う。
spec_file() {
    if [ -f "${SPEC_DIR}/$1.yml" ]; then
        echo "${SPEC_DIR}/$1.yml"
    else
        echo "${SPEC_DIR}/$1api.yml"
    fi
}

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
    spec="$(spec_file "${module}")"
    if [ ! -f "${spec}" ]; then
        echo "spec not found for module '${module}': ${spec}" >&2
        exit 1
    fi
    # spec は SPEC_DIR 配下にあるので、リポジトリとは別に読み取り専用で
    # マウントする（SPEC_DIR がリポジトリ外でも動くようにするため）。
    spec_mount="$(cd "$(dirname "${spec}")" && pwd)"
    target="/spec/$(basename "${spec}")"

    docker run --rm --user "$(id -u):$(id -g)" \
    -v ${PWD}:/local -v "${spec_mount}:/spec:ro" \
    openapitools/openapi-generator-cli:v7.2.0 generate \
    -i ${target} \
    -g java \
    --additional-properties=modelPackage=saasus.sdk.${module}.models,apiPackage=saasus.sdk.${module}.api \
    -o /local/generated/${module} \
    --additional-properties useOneOfDiscriminatorLookup=true,disallowAdditionalPropertiesIfNotPresent=false,enumUnknownDefaultCase=true

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
