package ch.vii.git.swagger.sample.rest;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestParam;

import ch.vii.git.swagger.sample.rest.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/app")
@Api
public class UserControllerRest {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	@GET
	@POST
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get List of Users",
		notes = "List can be filtered by Name",
		response = Person.class,
    	responseContainer = "List"
    )
    public List<Person> getUsers(@RequestParam(value="name", defaultValue="World") String name) {
		
        return  Collections.emptyList(); // new Person(counter.incrementAndGet(),
                         //   String.format(template, name));
    }
}
