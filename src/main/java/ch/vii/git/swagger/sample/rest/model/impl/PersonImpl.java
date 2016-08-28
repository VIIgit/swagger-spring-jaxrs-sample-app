package ch.vii.git.swagger.sample.rest.model.impl;

import ch.vii.git.swagger.sample.rest.model.ContactInfo;
import ch.vii.git.swagger.sample.rest.model.EmailType;
import ch.vii.git.swagger.sample.rest.model.EntityLifeCycle;

public class PersonImpl implements ContactInfo {

	private String name;
	private String email;
	private EmailType emailType;
	private String status;
	private EntityLifeCycle entityLifeCycle;

	public PersonImpl() {
		this.entityLifeCycle = EntityLifeCycle.DRAFT;
	}

	public PersonImpl(String name) {
		this.name = name;
	}

	public PersonImpl(String name, String email) {
		this(name);
		this.email = email;
	}

	public PersonImpl(String name, String email, EmailType emailType, String status, EntityLifeCycle entityLifeCycle) {
		this(name, email);
		this.emailType = emailType;
		this.status = status;
		this.entityLifeCycle = entityLifeCycle;
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

	public EntityLifeCycle getEntityLifeCycle() {
		return entityLifeCycle;
	}

	public void setEntityLifeCycle(EntityLifeCycle entityLifeCycle) {
		this.entityLifeCycle = entityLifeCycle;
	}
}
