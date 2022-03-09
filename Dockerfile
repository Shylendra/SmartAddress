FROM openjdk:8-jdk-alpine
EXPOSE 9091
ARG JAR_FILE=smartaddress-web/target/*.jar
COPY ${JAR_FILE} /usr/app/
WORKDIR /usr/app/
RUN sh -c 'touch smartaddress-web-1.0-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","smartaddress-web-1.0-SNAPSHOT.jar"]

