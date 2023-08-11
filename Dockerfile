FROM gradle:8.0.0-jdk17-alpine as build
COPY --chown=gradle:gradle . /builder
WORKDIR /builder
RUN gradle build --stacktrace

FROM openjdk:17-slim
EXPOSE 8080
COPY --from=build /builder/build/libs/threem-1.0.jar /app/
RUN bash -c 'touch /app/threem-1.0.jar'
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/threem-1.0.jar"]