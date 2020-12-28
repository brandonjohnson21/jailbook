FROM openjdk:8
ADD build/libs/jailbook-0.0.1-SNAPSHOT.jar jailbook-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "jailbook-0.0.1-SNAPSHOT.jar"]