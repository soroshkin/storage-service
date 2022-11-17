FROM adoptopenjdk:11-jre-hotspot as builder
MAINTAINER epam.com
VOLUME /tmp
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} storage-service.jar
ENTRYPOINT ["java","-jar","/storage-service.jar"]