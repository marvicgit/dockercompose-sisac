### CREACION DE JAR ###
FROM maven:3.6-jdk-8-alpine AS builder
# COPY dependencias/ojdbc7-12.1.0.1.jar /root/.m2/repository/com/oracle/ojdbc7/12.1.0.1/
WORKDIR /app
COPY pom.xml .

RUN mvn -e -B dependency:go-offline
COPY src ./src
RUN cd /app && mvn -e -B package -Dmaven.test.skip=true

#### EJECUCION DEL JAR ####
FROM openjdk:8-jdk-alpine

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

#COPY ./target/aate*.jar /app.jar
COPY --from=builder /app/target/*.jar /app.jar

ENV host="postgres_server"
ENV database="sisacse"
ENV username="postgres"
ENV password="123"


ENTRYPOINT exec java -jar /app.jar
EXPOSE 8080