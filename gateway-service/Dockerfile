FROM openjdk:11
COPY "./build/libs/gateway-service-0.0.1-SNAPSHOT.jar" "./gateway-service.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]