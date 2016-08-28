package ch.vii.git.swagger.sample.app;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import ch.vii.git.swagger.sample.rest.impl.UserControllerRestImpl;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

@Component
@ApplicationPath("/app")
public class AppResourceConfig extends ResourceConfig {
	public AppResourceConfig() {
		register(UserControllerRestImpl.class);
		register(CORSResponseFilter.class);

		configureSwagger();
	}

	private void configureSwagger() {
		register(ApiListingResource.class);
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http", "https" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/app");
		beanConfig.setTitle("swagger, spring, jax-rs API Sample");
		beanConfig.setDescription("https://github.com/VIIgit/swagger-spring-jaxrs-sample-app");
		beanConfig.getSwagger().addConsumes(MediaType.APPLICATION_JSON);
		beanConfig.getSwagger().addProduces(MediaType.APPLICATION_JSON);
		beanConfig.setContact("VIIGit");
		beanConfig.setResourcePackage("ch.vii.git.swagger.sample.rest");
		beanConfig.setPrettyPrint(false);
		beanConfig.setScan();
	}

}
