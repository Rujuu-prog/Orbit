# ベースイメージを指定
FROM openjdk:21-jdk-slim

# 作業ディレクトリを設定
WORKDIR /home/app

# Mavenのビルドツールをインストール
RUN apt-get update && apt-get install -y maven

# 依存関係をインストール（これにより、コードが変更されても依存関係を再インストールしなくてOK）
COPY ../../../pom.xml .
RUN mvn dependency:resolve

# srcディレクトリをマウントするため、コードをコピーしない

# サービスを開始するコマンド
CMD ["mvn", "spring-boot:run"]
