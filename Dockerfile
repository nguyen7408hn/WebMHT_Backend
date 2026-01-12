# Sử dụng Maven với Eclipse Temurin để build code
FROM maven:3.8.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copy file cấu hình để tận dụng cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code và build file jar
COPY src ./src
RUN mvn clean package -DskipTests -B

# Sử dụng JRE của Eclipse Temurin để chạy ứng dụng (nhẹ và ổn định hơn)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy file jar đã build từ stage trước
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
