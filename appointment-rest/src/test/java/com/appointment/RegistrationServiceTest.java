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
import com.appointment.services.RegistrationService;
import com.appointment.test.dao.MyTestApplicationContext;
import com.appointment.test.dao.RegistrationDaoTest;

public class RegistrationServiceTest extends RegistrationDaoTest {

	private static final Logger logger = Logger
			.getLogger(RegistrationServiceTest.class);
	@Autowired
	private RegistrationService<Registration> service;
	@Autowired
	private IBaseBO<Registration> iBaseBO;

	@Test
	public void testCreateAndFindLog() throws Exception {
		ObjectId id = null;
		Registration registration = new Registration();
		registration.setId(new ObjectId());
		registration.setOrgName("UniqueNotion" + Math.random());
		registration.setOrgPrefix("UN" + Math.random());
		registration.setEmail("test@test.com");
		registration.setContact("+31647608916");
		registration.setCreatedBy("Parag2");
		registration.setCreateTimestamp(new Date());
		id = service.add(registration);
		logger.debug("log.id =" + id);

		registration = (Registration) service.get(id);
		logger.debug("registration = " + registration);
		Assert.assertNotNull(registration);
	}

	@Test
	public void duplicateRecord() throws Exception {

		BasicConfigurator.configure();

		ObjectId id = null;

		Registration registration = new Registration();
		registration.setId(new ObjectId());
		registration.setOrgName("UniqueNotion");
		registration.setOrgPrefix("UN");
		registration.setEmail("test@test.com");
		registration.setContact("+31647608916");
		registration.setCreatedBy("Parag2");
		registration.setCreateTimestamp(new Date());
		id = service.add(registration);
		registration = new Registration();
		registration.setId(new ObjectId());
		registration.setOrgName("UniqueNotion");
		registration.setOrgPrefix("UN");
		registration.setEmail("test@test.com");
		registration.setContact("+31647608916");
		registration.setCreatedBy("Parag2");
		registration.setCreateTimestamp(new Date());
		id = service.add(registration);
		logger.debug("log.id =" + id);

		registration = (Registration) service.get(id);
		logger.debug("registration = " + registration);
		Assert.assertNull(registration);
	}

	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		super.setUp();
		BasicConfigurator.configure();

		service = (RegistrationService<Registration>) MyTestApplicationContext
				.getInstance().getBean("registrationService");

	}
}
