package com.appointment.test.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Registration;

public class RegistrationDaoTest {

	private static final Logger logger = Logger
			.getLogger(RegistrationDaoTest.class);
	static Process p = null;
	@Autowired
	private BaseDao<Registration> dao;

	protected ObjectId id = null;

	@Before
	public void setUp() throws Exception {
		// @Todo Run mongo with a test specific .js file to produce initial data
		// state
		BasicConfigurator.configure();

		dao = (BaseDao<Registration>) MyTestApplicationContext.getInstance()
				.getBean("regDao");
	}

	@Test
	public void testRegistration_Insert() {
		Registration registration = createRegistration();

		Registration insertedRegistration = dao.insert(registration);

		Registration insertedReg = dao.selectByPk(insertedRegistration.getId(),
				Registration.class);
		Assert.assertNotNull(" Registration inserted", insertedReg);
	}

	@Test
	public void testRegistration_Delete() {
		Registration Registration = createRegistration();

		Registration insertedRegistration = dao.insert(Registration);

		Registration insertedReg = dao
				.selectByPk(Registration.getId(), Registration.class);
		dao.delete(insertedReg, Registration.class);
		Registration deleteReg = dao.selectByPk(insertedRegistration.getId(),
				Registration.class);
		Assert.assertNull("Registration deleted", deleteReg);
	}

	@Test
	public void testRegistration_Find() {
		Registration Registration = createRegistration();

		Registration insertedRegistration = dao.insert(Registration);

		Registration fetchReg = dao.selectByPk(insertedRegistration.getId(),
				Registration.class);
		Assert.assertTrue("fetched and created should be same", fetchReg
				.getId().equals(Registration.getId()));
	}

	@Test
	public void testRegistration_FindAll() {
		Registration Registration = createRegistration();

		List<Registration> fetched = dao.findAll(Registration.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testRegistration_CountAll() {
		Registration Registration = createRegistration();

		long recordCount = dao.countAll(Registration.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}
	

	@Test
	public void testRegistration_Update() {
		Registration registration = createRegistration();

		Registration insertedRegistration = dao.insert(registration);
		insertedRegistration.setContact("Devendra");
		Registration fetchReg = dao.update(insertedRegistration);
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
