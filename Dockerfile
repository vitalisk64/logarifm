FROM openjdk:11
ARG JAR_FILE=target/gs-spring-boot-docker-0.1.0.jar
ENV JVM_JMX_OPTIONS="-Xmx512m -Djava.security.egd=file:/dev/./urandom -Djava.rmi.server.hostname=127.0.0.1 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.rmi.port=1099 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -javaagent:/jmx_prometheus_javaagent-0.13.0.jar=8082:/config.yaml"
COPY ${JAR_FILE} app.jar
COPY ./jmx_prometheus_javaagent-0.13.0.jar jmx_prometheus_javaagent-0.13.0.jar
COPY config.yaml config.yaml
EXPOSE 8080 8081 1099 8082
ENTRYPOINT exec java $JVM_JMX_OPTIONS -jar app.jar


#ENV JVM_JMX_OPTIONS="-Xmx512m -Djava.security.egd=file:/dev/./urandom -Djava.rmi.server.hostname=127.0.0.1 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.rmi.port=1099 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -javaagent:/app/jmx_prometheus_javaagent-0.13.0.jar=8082:/app/jmx_exporter.yaml"
#ARG JAR_FILE
#ADD ${JAR_FILE} /app/calculation-service.jar
#ADD ./lib/jmx_prometheus_javaagent-0.13.0.jar /app/jmx_prometheus_javaagent-0.13.0.jar
#ADD ./jmx_exporter.yaml /app/jmx_exporter.yaml
#EXPOSE 8080 8081 1099 8082
#ENTRYPOINT exec java $JVM_JMX_OPTIONS -jar /app/calculation-service.jar