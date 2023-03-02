FROM eclipse-temurin:17-jdk-focal

COPY client/target/client-0.0.1-SNAPSHOT.jar client-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/client-0.0.1-SNAPSHOT.jar"]
EXPOSE 9000
