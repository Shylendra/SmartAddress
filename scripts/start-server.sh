#!/bin/bash
echo 'Starting Spring Boot app - SmartAddress'
java -jar /home/ec2-user/smartaddress-web-1.0-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &