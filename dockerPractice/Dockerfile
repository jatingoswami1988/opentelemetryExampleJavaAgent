FROM eclipse-temurin:21-jdk
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar
ADD target/dockerpractice.jar /app.jar
#EXPOSE 9898

# We can keep these parameters inside docker-compose file as well so removing from here
#ENTRYPOINT java -javaagent:opentelemetry-javaagent.jar -Dotel.traces.exporter=otlp -Dotel.exporter.oltp.endpoint=http://jaeger-all-in-one:4317 -Dotel.logs.exporter=logging -Dotel.metrics.exporter=none -jar app.jar
ENTRYPOINT java -javaagent:opentelemetry-javaagent.jar -jar /app.jar
