FROM openjdk:11
COPY "./build/libs/showtimes-service-0.0.1-SNAPSHOT.jar" "./showtimes-service.jar"
EXPOSE 9070
ENTRYPOINT ["java", "-jar", "showtimes-service.jar"]