FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

COPY target/Java_Springboot-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080


# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]