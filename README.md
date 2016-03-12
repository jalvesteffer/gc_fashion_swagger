# swagger-single
Repository to showcase how to create a single Swagger Location/Documentation for all your micro services.

Challenge:
   Swagger generates different URL/document for each microservice. There is no way currently to view complete list and details of all micro services at one place.


This is currently using a static list of services from the application.yaml.

Need to enhance the application to retrieve the list from Eureka (registry server) or Zuul (API gateway) so that the list will be dynamic.

Changes to add services:
    Update application.yaml file under resources and add the list to GatewaySwaggerResourceProvider.java file. 
(This can be improved and will be updated later.)


Docker file is also available to create an image. 

If you dont use Zuul or Eureka, please remove the dependency on it from Gradile file and Application file.
