FROM openjdk:11
COPY "./build/libs/eureka-service-0.0.1-SNAPSHOT.jar" "./eureka-service.jar"
EXPOSE 9010
ENTRYPOINT ["java", "-jar", "eureka-service.jar"]