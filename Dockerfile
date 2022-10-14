FROM openjdk:8
EXPOSE 9595
ADD /target/employee-application.jar employee-application.jar
CMD [ "java", "-jar", "/employee-application.jar" ]