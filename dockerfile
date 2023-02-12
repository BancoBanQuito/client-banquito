FROM eclipse-temurin:17-jdk-focal

COPY target/client-0.1.jar client-0.1.jar
ENTRYPOINT ["java","-jar","/agencias-ud-0.1.jar"]
