# 本番のイメージ作成用
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /home/app

# プロジェクトの依存関係をダウンロードするためにpom.xmlのみをコピー
COPY ../../../pom.xml .
RUN mvn dependency:go-offline -B

# 実行用の軽量なイメージ
FROM openjdk:17-jdk-alpine
WORKDIR /home/app
COPY --from=build /home/app/target/app.jar app.jar

# エントリーポイント
ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]
