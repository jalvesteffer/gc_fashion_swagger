# swagger-single
Repository to showcase how to create a single Swagger Documentation for multiple services

This is currently using a static list of services from the application.yaml.

Need to enhance the application to retrieve the list from Eureka (registry server) or Zuul (API gateway) so that the list will be dynamic.

Update application.yaml file under resources and add the list to GatewaySwaggerResourceProvider.java file. 
(This can be improved and will be updated later.)

Docker file is also available to create an image. 

