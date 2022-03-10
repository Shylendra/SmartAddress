FROM openjdk:8-jdk-alpine
EXPOSE 9091
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /usr/app/
WORKDIR /usr/app/
RUN sh -c 'touch smartaddress-api.jar'
ENTRYPOINT ["java","-jar","smartaddress-api.jar"]

