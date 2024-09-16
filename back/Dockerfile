# Étape 1 : Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copier uniquement le fichier pom.xml pour installer les dépendances dans une couche distincte
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copier le reste du code et le builder
COPY . .
RUN mvn clean package -DskipTests

# Étape 2 : Run
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copier uniquement le fichier JAR généré
COPY --from=build /app/target/bookstore-back.jar /app/bookstore-back.jar

# Exposer le port 8080
EXPOSE 8080

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "/app/bookstore-back.jar"]
