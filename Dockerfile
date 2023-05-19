FROM gradle:8-jdk17-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM eclipse-temurin:17
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/threem-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "threem-0.0.1-SNAPSHOT.jar"]