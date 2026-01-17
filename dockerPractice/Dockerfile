FROM eclipse-temurin:21-jdk

# Just download the agent and copy the jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

COPY target/*.jar app.jar

EXPOSE 9898

# Simple entrypoint; all config comes from docker-compose
ENTRYPOINT ["java", "-jar", "app.jar"]