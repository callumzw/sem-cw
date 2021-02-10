FROM openjdk:latest
COPY ./target/seMethods-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "0.1.0.2-jar-with-dependencies.jar"]