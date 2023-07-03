FROM eclipse-temurin:17-jdk AS rest-service
MAINTAINER gheorghem
COPY target/rest-service-0.0.1-SNAPSHOT.jar rest-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/rest-service-0.0.1-SNAPSHOT.jar"]