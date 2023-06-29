FROM openjdk:8
EXPOSE 8082
ADD smartaddress-web/target/smartaddress-api.jar smartaddress-api.jar
ENTRYPOINT ["java","-jar","/smartaddress-api.jar"]

