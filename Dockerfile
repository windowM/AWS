#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=build/libs/AWS-0.0.1-SNAPSHOT.jar
#COPY $JAR_FILE app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

# Stage 1: Build
FROM openjdk:17-jdk-alpine AS build

# Set working directory
WORKDIR /app

# Copy Gradle Wrapper files and project files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Grant execution rights on gradlew
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build --no-daemon -x test

# Stage 2: Run
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/AWS-0.0.1-SNAPSHOT.jar test.jar

# Expose port 8080
EXPOSE 8080

# Define the entrypoint
ENTRYPOINT ["java", "-jar", "test.jar"]