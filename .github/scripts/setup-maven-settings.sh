#!/bin/bash

# ~/.m2 ディレクトリを作成
mkdir -p ~/.m2

# settings.xml を生成
cat <<EOF > ~/.m2/settings.xml
<settings>
  <servers>
    <server>
      <id>ossrh</id>
      <username>${OSSRH_USERNAME}</username>
      <password>${OSSRH_PASSWORD}</password>
    </server>
  </servers>
</settings>
EOF
