FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} soul-academy.jar
ENTRYPOINT ["java", "-jar", "/soul-academy.jar"]
