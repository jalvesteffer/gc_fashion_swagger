FROM java:11
MAINTAINER George Varghese 
LABEL Description="Image for swagger Single Documentation Server for Microservices" Version="1.0"
VOLUME /tmp
ADD swagger-single-0.1.0.jar app.jar
EXPOSE 8012
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
