package com.appointment;

import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.bo.IBaseBO;
import com.appointment.domain.Registration;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

public class RegistrationServiceTest {

	private static final Logger logger = Logger
			.getLogger(RegistrationServiceTest.class);
	@Autowired
	private BaseService<Registration> service;
	@Autowired
	private IBaseBO<Registration> iBaseBO;

	@Test
	public void testCreateAndFindLog() throws Exception {
		Registration savedRegistration = null;
		Registration registration = new Registration();
		registration.setId(new ObjectId());
		registration.setOrgName("UniqueNotion" + Math.random());
		registration.setOrgPrefix("UN" + Math.random());
		registration.setEmail("test@test.com");
		registration.setContact("+31647608916");
		registration.setCreatedBy("Parag2");
		registration.setCreateTimestamp(new Date());
		savedRegistration = service.add(registration);
		logger.debug("savedRegistration {}" + savedRegistration);

		registration = (Registration) service.get(savedRegistration.getId());
		logger.debug("registration = " + registration);
		Assert.assertNotNull(registration);
	}

	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		BasicConfigurator.configure();

		service = (BaseService<Registration>) MyTestApplicationContext
				.getInstance().getBean("registrationService");

	}
}
