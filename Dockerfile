FROM eclipse-temurin21-jdk AS build

WORKDIR app

COPY . .

RUN .mvnw clean package -DskipTests

FROM eclipse-temurin21-jre

WORKDIR app

COPY --from=build apptargetquarkus-app .

EXPOSE 8080

CMD [java, -jar, quarkus-run.jar]
