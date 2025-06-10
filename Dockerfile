FROM maven:3-eclipse-temurin-22 AS build

COPY . .

RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:21-jdk-slim


COPY --from=build /target/App-logistic-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]