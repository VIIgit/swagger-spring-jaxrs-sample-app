# swagger-spring-jaxrs-sample-app


### Setup Spring Boot Rest App with JAX-RS

* Add spring-boot-starter-jersey in pom.xml

```xml
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
```

* Create a Controller and enrich with JAX-RS(Jersey) Annotations

```java
	@Path("/app")
	public class UserControllerRest {
	
		@GET
		@Path("/users")
		@Produces(MediaType.APPLICATION_JSON)
	    public List<Person> getUsers(@RequestParam(value="name", defaultValue="World") String name) {
        	return  Collections.emptyList(); 
    	}
	}
```

* Add an Entity

```java
	public class Person {
		String getName(){return null};
	}
```

* Register Controller in Spring Boot

```java
	@Component
	public class AppResourceConfig extends ResourceConfig {
    	public AppResourceConfig() {
        	registerEndpoints();
	    }
	
    	private void registerEndpoints() {
    		register(UserControllerRest.class);
	    }
    }
```

* launch Spring Boot and call Rest Service endpoint

```
	http://localhost:8080/app/rest/users
```
or as wadl

```
	http://localhost:8080/app/rest/application.wadl
```


### Add Swagger 

* JAX-RS dependency to pom.xml  

```xml
	<dependency>
		<groupId>io.swagger</groupId>
		<artifactId>swagger-jersey2-jaxrs</artifactId>
		<version>1.5.9</version>
	</dependency>
```

* Configure swagger

```java
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
```

* Add Swagger API annotation

```java
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
```
	
* launch Spring Boot and call Swagger json/yaml endpoint

```
	http://localhost:8080/app/swagger.json
```
or 
```
	http://localhost:8080/app/swagger.yaml
```

# Cors

Register [CORSResponseFilter][] in [AppResourceConfig][] to support Cross-Origin Resource Sharing (CORS) 

# Generate static swagger.json with maven

```xml
	<!-- Generates static swagger.json -->
	<plugin>
		<groupId>com.github.kongchen</groupId>
		<artifactId>swagger-maven-plugin</artifactId>
		<version>3.1.3</version>
		<configuration>
			<apiSources>
				<apiSource>
					<springmvc>false</springmvc>
					<locations>ch.vii.git.swagger.sample.rest</locations>
					<schemes>http,https</schemes>
					<host>localhost:[port]</host>
					<basePath>/app</basePath>
					<info>
						<title>Swagger REST API</title>
						<version>${project.version}</version>
						<description>This is a sample spec for our REST API. Generated at ${maven.build.timestamp}</description>
						<termsOfService>
							https://github.com/VIIgit/swagger-spring-jaxrs-sample-app
						</termsOfService>
						<contact>
							<email>github(@)vii.ch</email>
							<name>Erwin</name>
							<url>https://github.com/VIIgit/</url>
						</contact>
						<license>
							<url>https://raw.githubusercontent.com/VIIgit/swagger-spring-jaxrs-sample-app/master/LICENSE</url>
							<name>Apache Licence 2.0</name>
						</license>
					</info>
					<swaggerDirectory>src/main/resources/swagger-ui/dist</swaggerDirectory>
				</apiSource>
			</apiSources>
		</configuration>
		<executions>
			<execution>
				<phase>compile</phase>
				<goals>
					<goal>generate</goal>
				</goals>
			</execution>
		</executions>
	</plugin>
```
Generates a static json file [SwaggerJson][] 

# Swagger-ui

* Configure swagger

With JAX-RS (Jersey) the servlet path is by default set to /*. To be able to add static html like swagger-ui add an ApplicationPath annotation to be able to configure other resources.

```java
	@Component
	@ApplicationPath("/app")
	public class AppResourceConfig extends ResourceConfig {
		...
	}
```


```java
	@Configuration
	@EnableWebMvc
	public class WebConfig extends WebMvcConfigurerAdapter {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/swagger-ui/dist/");
		}
	}
```
* launch swagger-ui

```
	http://localhost:8080/swagger-ui/index.html
```
# Swagger build plugin

JAX-RS & SpringMVC supported maven build plugin, helps you generate Swagger JSON and API document in build phase. [swagger-maven-plugin]

# Rich API Sample

Rich documentation example were all [Swagger Api][]  attributes are used and the Rest Service has been separated to a annotated Java Interface and the implementation. In my opinion the way a Rest Service should be designed.    

[swagger-maven-plugin]: https://github.com/kongchen/swagger-maven-plugin
[Swagger Api]: https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X
[CORSResponseFilter]: https://github.com/VIIgit/swagger-spring-jaxrs-sample-app/blob/master/src/main/java/ch/vii/git/swagger/sample/app/CORSResponseFilter.java
[AppResourceConfig]: https://github.com/VIIgit/swagger-spring-jaxrs-sample-app/blob/master/src/main/java/ch/vii/git/swagger/sample/app/AppResourceConfig.java
[SwaggerJson]: https://raw.githubusercontent.com/VIIgit/swagger-spring-jaxrs-sample-app/master/src/main/resources/swagger-ui/dist/swagger.json
