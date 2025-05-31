# Etapa de build
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

# Garanta permissão de execução
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/quarkus-app .

EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
