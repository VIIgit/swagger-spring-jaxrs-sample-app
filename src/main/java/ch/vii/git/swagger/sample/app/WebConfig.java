package ch.vii.git.swagger.sample.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/swagger-ui/dist/");
	}

	// @Override
	// public void addCorsMappings(CorsRegistry registry) {
	//
	// registry.addMapping("/api/**").allowedOrigins("http://localhost")
	// // .allowedMethods("PUT", "DELETE","GET","POST")
	// // .allowedHeaders("header1", "header2", "header3")
	// // .exposedHeaders("header1", "header2")
	// // .allowCredentials(false)
	// .maxAge(3600);
	// }
}