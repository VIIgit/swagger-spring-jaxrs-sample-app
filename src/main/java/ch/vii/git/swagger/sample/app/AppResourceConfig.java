package ch.vii.git.swagger.sample.app;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

import ch.vii.git.swagger.sample.rest.UserControllerRest;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

@Component
public class AppResourceConfig extends ResourceConfig {
    public AppResourceConfig() {
        registerEndpoints();
        configureSwagger();
    }

    private void registerEndpoints() {
    	register(UserControllerRest.class);
    }
    
    private void configureSwagger() {
        register(ApiListingResource.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/app");
        beanConfig.setTitle("Title");
        beanConfig.setDescription("Description");
        beanConfig.setContact("VIIGit");
        beanConfig.setResourcePackage("ch.vii.git.swagger.sample.rest");
        beanConfig.setPrettyPrint(false);
        beanConfig.setScan();
    }
    
}


