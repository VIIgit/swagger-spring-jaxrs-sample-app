package ch.vii.git.swagger.sample.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EmailType", description="Ability to diffentiate email addresses")
public enum EmailType {
	@ApiModelProperty(value="Private email addresses")
	PRIVATE, 
	
	@ApiModelProperty(value="Offical Business email addresses")
	BUSINESS,
	
	@ApiModelProperty(value="Unknown during first setup", hidden= true)
	UNKNOWN 
}
