FROM eclipse-temurin:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the build files into the container
COPY ./build/libs/clean-code-level-test.jar /app/clean-code-level-test.jar

# Expose the port your Spring app will run on (default: 8080)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "clean-code-level-test.jar"]