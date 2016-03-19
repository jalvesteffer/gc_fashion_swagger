# microservices-single-swagger
Repository to showcase how to create a *Single* SpringFox-Swagger Documentation Server for all your micro services.

### Challenge:
   SpringFox-Swagger generates different URL/document for each microservice. There is no way currently to view complete list of micro servies available or the details of all micro services at one place.

### Solution:
'microservices-single-swagger' is a springboot application and creates a documentation server where all the available microservices can be accessed. On the springfox swagger documentation page from this documentation server, use will be able to view all the microservices available (drop down on top) and select any service to view the documentation without leaving the page.

### Configuration:
In the **-application.yaml-** file, you can configure all your microservice swagger URLs.

```
documentation: 
  baseurl: http://localhost
  swagger: 
    services:   
      - 
        name: Service1
        url: ${documentation.baseurl}:8040/v2/api-docs?group=service1
        version: 2.0
      - 
        name: Service2
        url: ${documentation.baseurl}:8050/v2/api-docs?group=service2
        version: 2.0
```

Docker file is also available to create an image. 

#### Future enhacement:
   Need to enhance the application to retrieve the list from Gateway or registry (e.g. Eureka or Zuul) so that the list will be dynamic.

#### Remember:
* If you dont use Zuul or Eureka, please remove the dependency on it from Gradile and Application files.
* Cross origin Resource Sharing (CORS) need to be enabled on the micriservices server. Please let me know if you need details on how to configure the same in SpringBoot application.


Thanks to @dilipkrish (SpringFox Member) & @jhipster.
