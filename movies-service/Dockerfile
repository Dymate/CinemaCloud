FROM openjdk:11
COPY "./build/libs/movies-service-0.0.1-SNAPSHOT.jar" "./movies-service.jar"
EXPOSE 9060
ENTRYPOINT ["java", "-jar", "movies-service.jar"]