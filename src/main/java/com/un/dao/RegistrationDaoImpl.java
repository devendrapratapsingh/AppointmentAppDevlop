package com.un.dao;

import org.bson.types.ObjectId;

import com.un.domain.Registration;

public class RegistrationDaoImpl  extends AbstractBaseDao implements BaseDao<Registration> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Registration selectByPk(ObjectId id) {
		return (Registration) mongoTemplate.findById(id, Registration.class);
	}

	public ObjectId insert(Registration registration) {
		mongoTemplate.insert(registration);
		return registration.getId();
	}

}
