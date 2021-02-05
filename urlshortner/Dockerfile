FROM openjdk:8
EXPOSE 8080
ADD target/url-shortner-docker.jar url-shortner-docker.jar 
ENTRYPOINT ["java","-jar","/url-shortner-docker.jar"]