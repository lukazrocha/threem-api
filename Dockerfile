FROM eclipse-temurin:17
WORKDIR /app
EXPOSE 8080
ADD ./build/libs/threem-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "threem-0.0.1-SNAPSHOT.jar"]