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
	http://localhost:8080/app/users
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
	
* launch Spring Boot and call Swagger json endpoint

```
	http://localhost:8080/swagger.json
```

Response:
```javascript
{
	"swagger" : "2.0",
	"info" : {
		"description" : "Description",
		"version" : "1.0.2",
		"title" : null,
		"termsOfService" : null,
		"contact" : {
			"name" : "VIIGit",
			"url" : null,
			"email" : null
		},
		"license" : null
	},
	"host" : "localhost:8080",
	"basePath" : "/app",
	"tags" : null,
	"schemes" : [ "http" ],
	"consumes" : null,
	"produces" : null,
	"paths" : {
		"/app/users" : {
			"get" : {
				"tags" : null,
				"summary" : "Get List of Users",
				"description" : "List can be filtered by Name",
				"operationId" : "getUsers",
				"schemes" : null,
				"consumes" : [ "application/json" ],
				"produces" : [ "application/json" ],
				"parameters" : [ {
					"in" : "body",
					"name" : "body",
					"description" : null,
					"required" : false,
					"pattern" : null,
					"schema" : {
						"type" : "string",
						"required" : null,
						"discriminator" : null,
						"properties" : null,
						"externalDocs" : null,
						"title" : null,
						"format" : null,
						"description" : null,
						"example" : null,
						"additionalProperties" : null,
						"xml" : null,
						"enum" : null,
						"default" : null
					},
					"x-examples" : null
				} ],
				"responses" : {
					"200" : {
						"description" : "successful operation",
						"schema" : {
							"type" : "array",
							"format" : null,
							"example" : null,
							"xml" : null,
							"position" : null,
							"description" : null,
							"title" : null,
							"readOnly" : null,
							"uniqueItems" : null,
							"items" : {
								"format" : null,
								"example" : null,
								"xml" : null,
								"position" : null,
								"description" : null,
								"title" : null,
								"readOnly" : null,
								"$ref" : "#/definitions/Person"
							},
							"maxItems" : null,
							"minItems" : null
						},
						"examples" : null,
						"headers" : null
					}
				},
				"security" : null,
				"externalDocs" : null,
				"deprecated" : null
			},
			"head" : null,
			"post" : null,
			"put" : null,
			"delete" : null,
			"options" : null,
			"patch" : null,
			"parameters" : null
		}
	},
	"securityDefinitions" : null,
	"definitions" : {
		"Person" : {
			"type" : "object",
			"required" : null,
			"discriminator" : null,
			"properties" : {
				"name" : {
					"type" : "string",
					"format" : null,
					"example" : null,
					"xml" : null,
					"position" : null,
					"description" : null,
					"title" : null,
					"readOnly" : null,
					"minLength" : null,
					"maxLength" : null,
					"pattern" : null,
					"default" : null,
					"enum" : null
				}
			},
			"externalDocs" : null,
			"title" : null,
			"format" : null,
			"description" : null,
			"example" : null,
			"additionalProperties" : null,
			"xml" : null,
			"enum" : null,
			"default" : null
		}
	},
	"parameters" : null,
	"responses" : null,
	"externalDocs" : null,
	"securityRequirement" : null
}
```
    