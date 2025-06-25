FROM maven:3-openjdk-17 AS build
WORKDIR /app

# Copy chỉ pom.xml để tận dụng cache
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copy source và build
COPY src ./src
RUN mvn clean package -DskipTests -B

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
