FROM eclipse-temurin:17-jre-alpine
COPY target/task.jar /app/task.jar
ENTRYPOINT java -jar /app/task.jar