FROM gradle:4.7.0-jdk8-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle compileApp --no-daemon

FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /home/gradle/src/build/services/*.jar /opt/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]