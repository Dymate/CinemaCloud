FROM openjdk:11
COPY "./build/libs/admin-service-0.0.1-SNAPSHOT.jar" "./admin-service.jar"
EXPOSE 9020
ENTRYPOINT ["java", "-jar", "admin-service.jar"]