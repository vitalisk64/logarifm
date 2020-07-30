FROM openjdk:11
ARG JAR_FILE=target/gs-spring-boot-docker-0.1.0.jar
COPY ${JAR_FILE} app.jar
COPY ./jmx_prometheus_javaagent-0.13.0.jar jmx_prometheus_javaagent-0.13.0.jar
ENTRYPOINT ["java","-javaagent:./jmx_prometheus_javaagent-0.13.0.jar=8080:config.yaml","-jar","/app.jar"]
