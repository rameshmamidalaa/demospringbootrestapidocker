FROM adoptopenjdk/openjdk8:latest

MAINTAINER Ramesh Mamidala <ramesh.mamidalaa@gmail.com>

COPY /target/springboot-2-restservice-basic-0.0.1-SNAPSHOT.jar /tmp

WORKDIR /tmp

RUN sh -c 'touch springboot-2-restservice-basic-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "springboot-2-restservice-basic-0.0.1-SNAPSHOT.jar"]