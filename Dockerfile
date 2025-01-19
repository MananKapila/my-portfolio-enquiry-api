# Stage 1: Build
FROM gradle:8.2.1-jdk17 AS build

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY build.gradle.kts settings.gradle.kts gradle.properties /app/

# Copy source code
COPY src /app/src

# Build the application
RUN gradle clean build --no-daemon

# Stage 2: Runtime
FROM openjdk:17-jdk-slim

# Set the working directory for the runtime
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
