FROM adoptopenjdk/openjdk11:alpine-slim
VOLUME /tmp
COPY /target/SpringbootSchedulerExample-*.jar springbootschedulerexample.jar
COPY src src
COPY Dockerfile Dockerfile
COPY pom.xml pom.xml
ENTRYPOINT ["java", "-jar", "springbootschedulerexample.jar"]
