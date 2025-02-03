# Use a base image with Java runtime
FROM openjdk:17-jdk-slim

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY . /app

# Build the application using Maven
RUN mvn clean install

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the application
CMD ["mvn", "spring-boot:run"]