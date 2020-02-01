FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY db.conf db.conf
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080