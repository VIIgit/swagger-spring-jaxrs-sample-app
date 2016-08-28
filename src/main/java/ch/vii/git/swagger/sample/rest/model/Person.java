package ch.vii.git.swagger.sample.rest.model;

import io.swagger.annotations.ApiModelProperty;

public interface Person {

	static final String STATUS_SINGLE = "single";

	String getName();

	@ApiModelProperty(value = "Person's relationship status (API: list of not type safe enumenration as strings with 'allowableValues' )", allowableValues = STATUS_SINGLE
			+ ",married,divorced")
	String getStatus();

	@ApiModelProperty(value = "Entity's LifeCyle Status ")
	EntityLifeCycle getEntityLifeCycle();
}
