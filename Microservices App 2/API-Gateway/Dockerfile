FROM openjdk:8
COPY ["target/*.jar","Api-Gateway.jar"]
ENTRYPOINT ["java","-jar","/Api-Gateway.jar"]
EXPOSE 9000