# Etapa de build
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/quarkus-app .

EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
