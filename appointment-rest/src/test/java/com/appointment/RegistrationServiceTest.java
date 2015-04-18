package com.appointment;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.domain.Customer;
import com.appointment.domain.Registration;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

public class RegistrationServiceTest {

	private static final Logger logger = Logger
			.getLogger(RegistrationServiceTest.class);
	static Process p = null;
	@Autowired
	private BaseService<Registration> service;

	protected ObjectId id = null;
	
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();

		service = (BaseService<Registration>) MyTestApplicationContext.getInstance()
				.getBean("registrationService");
	}


	@Test
	public void testRegistration_Insert() {
		Registration registration = createRegistration();

		Registration insertedRegistration = service.add(registration);

		Registration insertedReg = service.get(insertedRegistration.getId());
		Assert.assertNotNull(" Registration inserted", insertedReg);
	}

	@Test
	public void testRegistration_Delete() {
		Registration Registration = createRegistration();

		Registration insertedRegistration = service.add(Registration);

		Registration insertedReg = service
				.get(Registration.getId());
		service.remove(insertedReg, Registration.class);
		Registration deleteReg = service.get(insertedRegistration.getId()
				);
		Assert.assertNull("Registration deleted", deleteReg);
	}

	@Test
	public void testRegistration_Find() {
		Registration Registration = createRegistration();

		Registration insertedRegistration = service.add(Registration);

		Registration fetchReg = service.get(insertedRegistration.getId());
		Assert.assertTrue("fetched and created should be same", fetchReg
				.getId().equals(Registration.getId()));
	}

	@Test
	public void testRegistration_FindAll() {
		Registration Registration = createRegistration();

		List<Registration> fetched = service.getAll(Registration.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testRegistration_CountAll() {
		Registration Registration = createRegistration();

		long recordCount = service.countAll(Registration.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}
	

	@Test
	public void testRegistration_Update() {
		Registration registration = createRegistration();

		Registration insertedRegistration = service.add(registration);
		insertedRegistration.setContact("Devendra");
		Registration fetchReg = service.modify(insertedRegistration);
		Assert.assertTrue("fetched and created should be same", fetchReg
				.getId().equals(insertedRegistration.getId()));
	}
	
	

	private Registration createRegistration() {
		Registration registration = new Registration();
		registration.setContact("amit");
		registration.setCreatedBy("");
		registration.setCreateTimestamp(new Date());
		registration.setEmail("amitthapar123@gmail.com");
		registration.setId(new ObjectId());
		registration.setMessage("Registration to Doctors office");
		registration.setOrgName("Devendra-Amit & Company");
		registration.setOrgPrefix("DA&Co");
		registration.setType("Open");
		
		return registration;
	}
	
	// @BeforeClass
	public static void beforeClass() throws Exception {

		String[] command = new String[] {
				"/D:/amit/software/mongoDB/bin/mongod", "--dbpath",
				"/D:/amit/software/mongoDB/data", "--rest" };

		ProcessBuilder pb = new ProcessBuilder(command);

		p = pb.start();

		logger.debug("Process started with pid: " + p);

	}

	// @AfterClass
	public static void afterClass() throws Exception {
		// Stop mongod process
		boolean processClosed = false;

		Thread.sleep(5000);
		p.destroy();
		if (p != null) {
			while (!processClosed) {

				try {

					processClosed = true;
					Thread.sleep(500);
					logger.info(" Process destroyed: " + p.exitValue());
				} catch (IllegalThreadStateException itse) {
					logger.warn(itse);
					processClosed = false;
				}
			}
		}

	}
}
