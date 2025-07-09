# Use official OpenJDK 21 base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give permission to mvnw (in case it's not executable)
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port your app runs on
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/rewardapp-0.0.1-SNAPSHOT.jar"]
