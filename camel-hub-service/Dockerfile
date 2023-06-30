FROM eclipse-temurin:17-jdk as camel-hub-service
MAINTAINER gheorghem
COPY target/camel-hub-service-0.0.1-SNAPSHOT.jar camel-hub-service-0.0.1-SNAPSHOT.jar
ENV SERVER_PORT=8080
ENTRYPOINT ["java","-jar","/camel-hub-service-0.0.1-SNAPSHOT.jar"]