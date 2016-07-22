package ch.vii.git.swagger.sample.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ContactInfoModel", description="Person with an email address")

public interface ContactInfo extends Person {
	String getEmail();
	
	@ApiModelProperty(value="Ability to diffentiate email addresses", required=true)
	EmailType getEmailType();
}

