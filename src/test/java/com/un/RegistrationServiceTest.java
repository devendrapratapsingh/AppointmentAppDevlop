package com.un;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.un.bo.IBaseBO;
import com.un.domain.Registration;
import com.un.services.RegistrationService;

public class RegistrationServiceTest extends RegistrationDaoTest {

	private static final Logger logger = Logger
			.getLogger(RegistrationServiceTest.class);
	@Autowired
	private RegistrationService<Registration> service;
	@Autowired
	private IBaseBO<Registration> iBaseBO;

	@Test
	public void testCreateAndFindLog() throws Exception {

		BasicConfigurator.configure();

		ApplicationContext context = 
		    	   new ClassPathXmlApplicationContext(new String[] {"spring-config.xml"});
		 
		    
		    
		ObjectId id = null;

		Registration registration = new Registration();
		registration.setId(new ObjectId());
		registration.setOrgName("UniqueNotion"+Math.random());
		registration.setOrgPrefix("UN");
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
		logger.debug("log.id =" + id);

		registration = (Registration) service.get(id);
		logger.debug("registration = " + registration);
		Assert.assertNull(registration);
	}

	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		super.setUp();
		service = (RegistrationService<Registration>) MyTestApplicationContext
				.getInstance().getBean("registrationService");
		/*iBaseBO = (IBaseBO<Registration>) MyTestApplicationContext
				.getInstance().getBean("iBaseBO");*/
		

		System.out.println(service);
		// @TODO Run mongo with a test specific .js file to produce initial data
		// state
	}
}
