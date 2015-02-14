package com.appointment.test.dao;
import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
		logger.info("setting up test");
		BasicConfigurator.configure();

		dao = (BaseDao<Registration>) MyTestApplicationContext
				.getInstance().getBean("regDao");
	}

	
	@Test
	public void testInsertFindUpdateDeleteRegistration() throws Exception
	{
		Registration regfind = null;
		Registration reg = new Registration();
		reg.setContact("Test");
		reg.setCreatedBy("Amit");
		reg.setCreateTimestamp(new Date());
		reg.setEmail("amitthapar123@gmail.com");
		reg.setId(new ObjectId());
		reg.setMessage("Test Registration insertion");
		reg.setOrgName("CodeForFun");
		reg.setOrgPrefix("cff");
		reg.setType("Registration");
		
		id = dao.insert(reg);
		 
		logger.debug("Test - 1- registration inserted = " + reg.getMessage());
		Assert.assertNotNull(reg);
		
		regfind = dao.selectByPk(id);
		logger.debug("Test - 2-  registration find-------------------");
		logger.debug("Registration found--" +regfind.getOrgName());		
		Assert.assertNotNull(regfind);
		
			
		Registration regUp = new Registration();
		regUp.setContact("Test_UPDATE");
		regUp.setCreatedBy("Amit_UPDATE");
		regUp.setCreateTimestamp(new Date());
		regUp.setEmail("amitthapar123@gmail.com_UPDATE");
		regUp.setId(id);
		regUp.setMessage("Test Registration insertion_UPDATE----------");
		regUp.setOrgName("CodeForFun_UPDATE");
		regUp.setOrgPrefix("cff_UPDATE");
		regUp.setType("Registration_UPDATE");
		
		id = dao.update(regUp);
		logger.debug("Test - 3- registration UPDATED = " + regUp.getMessage());
		
		regfind = dao.selectByPk(id);
		logger.debug("Test - 4-  registration find updated-------------");
		logger.debug("Registration found Updated--" +regfind.getOrgName());		
		Assert.assertNotNull(regfind);
		
		
		logger.debug("Test - 5-  registration delete-------------------");
		Registration regDel = null;
		regDel = dao.selectByPk(id);
		dao.delete(regDel);
		logger.debug("Test - 5-  registration deleted------------------");
	}
	
	
	@After
	public void tearDown() throws Exception {
		// @Todo Drop database
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
		
		 String[] command = new String[] {
		 "/D:/amit/software/mongoDB/bin/mongod",
		 "--dbpath", "/D:/amit/software/mongoDB/data", "--rest" };
		 
		 ProcessBuilder pb = new ProcessBuilder(command);
		 
		 p = pb.start();
		

		logger.debug("Process started with pid: " + p);

	}

	@AfterClass
	public static void afterClass() throws Exception {
													  // Stop mongod process
													  boolean processClosed =
													  false;
													  
													  Thread.sleep(5000);
													  p.destroy(); if (p !=
													  null) { while
													  (!processClosed) {
													  
													  try {
													  
													  processClosed = true;
													  Thread.sleep(500);
													  logger.
													  info(" Process destroyed: "
													  + p.exitValue()); } catch
													  (
													  IllegalThreadStateException
													  itse) {
													  logger.warn(itse);
													  processClosed = false; }
													  } }
													 
	}

}
