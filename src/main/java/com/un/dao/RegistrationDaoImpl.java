package com.un.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.un.domain.Registration;

@Component
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
