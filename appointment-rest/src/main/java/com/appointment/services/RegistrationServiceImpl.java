package com.appointment.services;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.IBaseBO;
import com.appointment.domain.Registration;

@Service("registrationService")
public class RegistrationServiceImpl implements BaseService<Registration> {

	private static final Logger logger = Logger
			.getLogger(RegistrationServiceImpl.class);
	@Autowired
	private IBaseBO<Registration> baseBO;

	/**
	 * @return the baseBO
	 */
	public IBaseBO<Registration> getBaseBO() {
		return baseBO;
	}

	/**
	 * @param baseBO
	 *            the baseBO to set
	 */
	public void setBaseBO(IBaseBO<Registration> baseBO) {
		this.baseBO = baseBO;
	}

	public Registration add(Registration registration) {
		logger.debug("Adding a new Registration instance");
		return baseBO.add(registration);
	}

	public Registration get(ObjectId id) {
		return (Registration) baseBO.get(id);
	}

}
