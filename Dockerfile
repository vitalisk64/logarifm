FROM openjdk:11
ARG JAR_FILE=target/gs-spring-boot-docker-0.1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
