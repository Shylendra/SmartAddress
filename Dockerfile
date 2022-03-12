FROM openjdk:8-jdk-alpine
ARG JAR_FILE=smartaddress-web/target/*.jar
COPY ${JAR_FILE} /usr/app/
WORKDIR /usr/app/
RUN sh -c 'touch smartaddress-api.jar'
ENTRYPOINT ["java","-jar","smartaddress-api.jar","--spring.profiles.active=aws"]

