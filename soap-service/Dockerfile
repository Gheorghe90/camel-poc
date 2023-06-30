FROM eclipse-temurin:17-jdk AS soap-seervice
MAINTAINER gheorghem
COPY target/soap-service-0.0.1-SNAPSHOT.jar soap-service-0.0.1-SNAPSHOT.jar
ENV SERVER_PORT=8081
ENTRYPOINT ["java","-jar","/soap-service-0.0.1-SNAPSHOT.jar"]