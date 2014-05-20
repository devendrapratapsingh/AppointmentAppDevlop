package com.un.services;


import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.un.bo.IBaseBO;
import com.un.domain.Registration;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService<Registration> {

	private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
	@Autowired
	private IBaseBO<Registration> baseBO;

	/**
	 * @return the baseBO
	 */
	public IBaseBO<Registration> getBaseBO() {
		return baseBO;
	}

	/**
	 * @param baseBO the baseBO to set
	 */
	public void setBaseBO(IBaseBO<Registration> baseBO) {
		this.baseBO = baseBO;
	}

	public ObjectId add(Registration registration) {
		logger.debug("Adding a new LogItem instance");
		return baseBO.add(registration);
	}

	public Registration get(ObjectId id) {
		return (Registration) baseBO.get(id);
	}

}
