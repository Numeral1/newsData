#pull official image jdk17

FROM openjdk:17.0.1

#set working directory
WORKDIR ./

#create directory for persisting data
VOLUME /tmp

#create variable JAR_FILE
ARG JAR_FILE=target/newsData-0.0.1-SNAPSHOT.jar

#copy file jar into app.jar file inside docker container
COPY ${JAR_FILE} newsData.jar

#executes command when starting the docker container
ENTRYPOINT [ "java", "-jar", "newsData.jar" ]