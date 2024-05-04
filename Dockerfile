FROM openjdk:17-jdk

WORKDIR /app

COPY build/libs/game-server-backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

CMD ["java", "-jar", "game-server-backend-0.0.1-SNAPSHOT.jar"]