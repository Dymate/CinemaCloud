FROM openjdk:11
COPY "./build/libs/bookings-service-0.0.1-SNAPSHOT.jar" "./bookings-service.jar"
EXPOSE 9080
ENTRYPOINT ["java", "-jar", "bookings-service.jar"]