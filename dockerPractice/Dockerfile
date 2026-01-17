FROM eclipse-temurin:21-jdk

ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

COPY target/*.jar app.jar

# Fixed syntax: No path in endpoint, exporters disabled, sampler forced ON
ENV JAVA_TOOL_OPTIONS="-javaagent:/opentelemetry-javaagent.jar \
-Dotel.traces.exporter=otlp \
-Dotel.exporter.otlp.endpoint=http://jaeger:4318 \
-Dotel.exporter.otlp.protocol=http/protobuf \
-Dotel.traces.sampler=always_on \
-Dotel.metrics.exporter=none \
-Dotel.logs.exporter=none \
-Dotel.service.name=dockerpractice"

EXPOSE 9898

ENTRYPOINT ["java", "-jar", "app.jar"]