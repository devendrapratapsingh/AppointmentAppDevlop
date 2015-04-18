package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.BaseBO;
import com.appointment.domain.Registration;

@Service("registrationService")
public class RegistrationServiceImpl implements BaseService<Registration> {

	private static final Logger logger = Logger
			.getLogger(RegistrationServiceImpl.class);
	@Autowired
	private BaseBO<Registration> baseBO;

	@Override
	public Registration get(ObjectId id) {
		logger.debug("Getting a stored Registration instance");
		Registration Registration = baseBO.get(id, Registration.class);
		return Registration;
	}
	@Override
	public Registration add(Registration reg) {
		logger.debug("Adding a new Registration instance");
		Registration Registration = baseBO.add(reg);
		return Registration;
	}
	@Override
	public Registration modify(Registration reg) {
		logger.debug("Modifying the Registration instance");
		Registration Registration = baseBO.add(reg);
		return Registration;
	}

	@Override
	public List<Registration> getAll(Class<Registration> entityClass) {
		logger.debug("Getting all the Registrations");
		List<Registration> fetched = baseBO.getAll(Registration.class);
		return fetched;
	}
	@Override
	public Long countAll(Class<Registration> entityClass) {
		logger.debug("Counting the Registrations");
		long recordCount = baseBO.countAll(Registration.class);
		return recordCount;
	}
	@Override
	public void remove(Registration entity, Class<Registration> entityClass) {
		logger.debug("removing the Registration");
		baseBO.remove(entity, entityClass);
	
	}
}
