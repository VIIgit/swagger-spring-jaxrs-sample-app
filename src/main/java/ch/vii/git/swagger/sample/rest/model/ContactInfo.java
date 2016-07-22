package ch.vii.git.swagger.sample.rest.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value="ContactInfoModel", description="Person with an email address")

public interface ContactInfo extends Person {
	String getEmail();
}

