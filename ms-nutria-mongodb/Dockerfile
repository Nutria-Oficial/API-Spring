FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY ms-nutria-mongodb/pom.xml .
RUN mvn dependency:go-offline
COPY ms-nutria-mongodb/src ./src
# Use o spring-boot:repackage para garantir o JAR executável
RUN mvn clean package spring-boot:repackage -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
