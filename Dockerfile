FROM openjdk:8
EXPOSE 8989
ADD /target/employee-appV1.jar employee-appV1.jar
CMD [ "java", "-jar", "/employee-appV1.jar" ]