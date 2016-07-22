package ch.vii.git.swagger.sample.rest.model;

import io.swagger.annotations.ApiModelProperty;

public interface Person {

	String getName();

	@ApiModelProperty(value = "Person's relationship status", allowableValues = "single,married,divorced")
	String getStatus();
}
