FROM openjdk:17.0.1-jdk
COPY target/shift-1.0-SNAPSHOT.jar /docker.jar
ENTRYPOINT ["java","-jar","/docker.jar"]