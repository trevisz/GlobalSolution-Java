FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/quarkus-app .

EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
