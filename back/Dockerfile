# Étape 1 : Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/bookstore-back.jar /app/bookstore-back.jar
ENTRYPOINT ["java", "-jar", "/app/bookstore-back.jar"]
