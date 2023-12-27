FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/assessment-roman-1.0-SNAPSHOT.jar assessment-roman-1.0.jar
EXPOSE 8870
CMD ["java", "-jar", "assessment-roman-1.0.jar"]