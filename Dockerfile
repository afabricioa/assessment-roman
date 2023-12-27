FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/roman-1.0-SNAPSHOT.jar assessment-roman-1.0.jar
EXPOSE 8080
CMD ["java", "-jar", "assessment-roman-1.0.jar"]