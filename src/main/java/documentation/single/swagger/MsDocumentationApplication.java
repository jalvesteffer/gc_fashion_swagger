package documentation.single.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author George Varghese
 * @version 1.0
 * https://github.com/varghgeorge
 */

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({SwaggerServicesConfig.class,SwaggerServicesConfig.SwaggerServices.class})
public class MsDocumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDocumentationApplication.class, args);
	}
}
