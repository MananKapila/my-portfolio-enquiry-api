# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/*.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Default environment variables for MongoDB (adjust as needed)
ENV MONGO_HOST=mongodb
ENV MONGO_PORT=27017
ENV MONGO_DATABASE=mydatabase

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
