# Build
FROM gradle:8.14.3-jdk21-alpine AS builder

WORKDIR /home/gradle

COPY settings.gradle.kts build.gradle.kts .
COPY src src
COPY gradle gradle

RUN gradle bootJar

# Run
FROM eclipse-temurin:21-alpine AS runtime

RUN addgroup -g 1000 app
RUN adduser -G app -D -u 1000 -h /app app

USER app
WORKDIR /app

COPY --from=builder --chown=1000:1000 /home/gradle/build/libs/*.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]



