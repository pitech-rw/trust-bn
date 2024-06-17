# Build the app
FROM maven:latest AS Build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


# Run the app
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=Build /app/target/*.jar trust-app.jar
EXPOSE 8080
CMD [ "java", "-jar", "trust-app.jar" ]