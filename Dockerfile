# 1) Build stage
FROM maven:3-openjdk-17 AS build
WORKDIR /app

# Chỉ copy pom + wrapper trước để tận dụng cache
COPY pom.xml mvnw .mvn/ ./
RUN ./mvnw dependency:go-offline -B

# Copy code và build
COPY src ./src
RUN ./mvnw clean package -DskipTests -B

# 2) Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy bất kỳ file JAR nào ra thành app.jar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
