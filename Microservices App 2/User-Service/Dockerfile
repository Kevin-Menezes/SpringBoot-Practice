FROM openjdk:8
COPY ["target/*.jar","User-Service.jar"]
ENTRYPOINT ["java","-jar","/User-Service.jar"]
EXPOSE 9002