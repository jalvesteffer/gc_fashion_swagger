package doc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Optional;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;

@Controller
@ApiIgnore
public class ApiResourceController {

	@Autowired(required = false)
	private SecurityConfiguration securityConfiguration;
	@Autowired(required = false)
	private UiConfiguration uiConfiguration;

	private final SwaggerResourcesProvider swaggerResources;

	@Autowired
	public ApiResourceController(SwaggerResourcesProvider swaggerResources) {
		this.swaggerResources = swaggerResources;
	}

	@RequestMapping(value = "/swagger-resources")
	@ResponseBody
	ResponseEntity<List<SwaggerResource>> swaggerResources() {
		List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
		resources.add(swaggerResource("myservice", "/myservice/v0", "2.0"));
		resources.add(swaggerResource("myservice2", "/myservice/v1", "2.0"));

		Collections.sort(resources);
		return new ResponseEntity<List<SwaggerResource>>(resources, HttpStatus.OK);
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setLocation(location);
		swaggerResource.setName(name);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

	@RequestMapping(value = "/configuration/security")
	@ResponseBody
	ResponseEntity<SecurityConfiguration> securityConfiguration() {
		return new ResponseEntity<SecurityConfiguration>(
				Optional.fromNullable(securityConfiguration).or(SecurityConfiguration.DEFAULT), HttpStatus.OK);
	}

	@RequestMapping(value = "/configuration/ui")
	@ResponseBody
	ResponseEntity<UiConfiguration> uiConfiguration() {
		return new ResponseEntity<UiConfiguration>(Optional.fromNullable(uiConfiguration).or(UiConfiguration.DEFAULT),
				HttpStatus.OK);
	}

}
