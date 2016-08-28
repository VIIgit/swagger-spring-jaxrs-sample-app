package ch.vii.git.swagger.sample.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ch.vii.git.swagger.sample.rest.model.ContactInfo;
import ch.vii.git.swagger.sample.rest.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/rest")
@Api
public interface UserControllerRest {

	@GET
	@Path("/users")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get List of Users", notes = "List can be filtered by Name", response = Person.class, responseContainer = "List")
	List<Person> getUsers(
			@ApiParam(value = "Filters the list by name beginning with.", required = false) @QueryParam(value = "name") String name);

	@POST
	@Path("/contacts")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get List of Users", notes = "List can be filtered by Name", response = ContactInfo.class, responseContainer = "List")
	List<ContactInfo> getContactInfo(ContactsRequest request);

	@XmlRootElement
	@ApiModel(description = "To filters the list")
	class ContactsRequest {
		@XmlElement
		@ApiModelProperty(value = "name beginning with")
		public String name;
	}

}
