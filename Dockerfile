FROM openjdk:8
EXPOSE 9595
ADD /target/employee-appV1.jar employee-appV1.jar
CMD [ "java", "-jar", "/employee-appV1.jar" ]