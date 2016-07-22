# swagger-spring-jaxrs-sample-app


### Setup Spring Boot Rest App with JAX-RS

* Add spring-boot-starter-jersey in pom.xml

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- JAX-RS --> 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jersey</artifactId>
		</dependency>
	</dependencies>

* Create a Controller and enrich with JAX-RS(Jersey) Annotations

	@Path("/app")
	public class UserControllerRest {
	
		@GET
		@Path("/users")
		@Produces(MediaType.APPLICATION_JSON)
	    public List<Person> getUsers(@RequestParam(value="name", defaultValue="World") String name) {
        	return  Collections.emptyList(); 
    	}
	}

* Add an Entity

	public class Person {
		String getName(){return null};
	}

* Register Controller in Spring Boot

	@Component
	public class AppResourceConfig extends ResourceConfig {
    	public AppResourceConfig() {
        	registerEndpoints();
	    }
	
    	private void registerEndpoints() {
    		register(UserControllerRest.class);
	    }
    }

* launch Spring Boot and call Rest Service endpoint

	http://localhost:8080/app/users

### Add Swagger 

* JAX-RS dependency to pom.xml  

	<dependency>
		<groupId>io.swagger</groupId>
		<artifactId>swagger-jersey2-jaxrs</artifactId>
		<version>1.5.9</version>
	</dependency>

* Configure swagger

	@Component
	public class AppResourceConfig extends ResourceConfig {
    	public AppResourceConfig() {
        	...
        	configureSwagger();
    	}

    	private void configureSwagger() {
        	register(ApiListingResource.class);
        	BeanConfig beanConfig = new BeanConfig();
        	beanConfig.setVersion("0.0.1");
        	beanConfig.setSchemes(new String[]{"http"});
        	beanConfig.setHost("localhost:8080");
        	beanConfig.setBasePath("/");
        	beanConfig.setDescription("Sample");
        	beanConfig.setContact("VIIGit");
        	beanConfig.setResourcePackage("ch.vii.git.swagger.sample.rest");
        	beanConfig.setPrettyPrint(true);
        	beanConfig.setScan(true);
    	}
	}

* Add Swagger API annotation

	...
	@Api
	public class UserControllerRest {
		...
		@ApiOperation(value = "Get List of Users",
			notes = "List can be filtered by Name",
			response = Person.class,
    		responseContainer = "List"
    	)
    	public List<Person> getUsers(@RequestParam(value="name", defaultValue="World") String name) {
    		...
    	}
	}
	
* launch Spring Boot and call Swagger json endpoint

	http://localhost:8080/swagger.json
	
```java
class xxx;
```
    