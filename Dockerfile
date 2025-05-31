FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copia especificamente o mvnw e dá permissão antes do restante
COPY mvnw mvnw
RUN chmod +x mvnw

# Agora copia o restante
COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/quarkus-app .

EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
