FROM java:8
MAINTAINER George Varghese
LABEL Description="Image for Single Instance of Swagger UI for all Microservices" Version="1.0"
VOLUME /tmp
ADD swagger-single-0.1.0.jar app.jar
EXPOSE 8012
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
