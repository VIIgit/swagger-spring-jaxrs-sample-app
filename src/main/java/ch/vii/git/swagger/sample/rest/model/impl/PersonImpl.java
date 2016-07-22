package ch.vii.git.swagger.sample.rest.model.impl;

import ch.vii.git.swagger.sample.rest.model.ContactInfo;
import ch.vii.git.swagger.sample.rest.model.EmailType;

public class PersonImpl implements ContactInfo {

	private String name;
	private String email;
	private EmailType emailType;
	private String status;

	public PersonImpl() {
	}

	public PersonImpl(String name) {
		this.name = name;
	}

	public PersonImpl(String name, String email) {
		this(name);
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public EmailType getEmailType() {
		return emailType;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}

	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
