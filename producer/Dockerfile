FROM openjdk:8-jdk-alpine
ARG JAR_FILE
EXPOSE 8282
COPY target/producer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]