package com.appointment.test.dao;

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
import com.appointment.domain.Customer;

public class CustomerDaoTest {
	
	private static final Logger logger = Logger
			.getLogger(CustomerDaoTest.class);
	static Process p = null;
	@Autowired
	private BaseDao<Customer> dao;
	
	protected ObjectId id = null;

	@Before
	public void setUp() throws Exception {
		// @Todo Run mongo with a test specific .js file to produce initial data
		// state
		logger.info("setting up test");
		BasicConfigurator.configure();

		dao = (BaseDao<Customer>) MyTestApplicationContext
				.getInstance().getBean("customerDao");
	}

	
	@Test
	public void testInsertFindUpdateDeleteCustomer() throws Exception
	{
		Customer cusfind = null;
		Customer cus = new Customer();
		cus.setName("amit");
		cus.setEmail("amitthapar123@gmail.com");
		cus.setId(new ObjectId());
		cus.setMobile(new Long("08803010194"));	
		
		id = dao.insert(cus);
		 
		logger.debug("Test - 1- Customer inserted = " + cus.getName());
		Assert.assertNotNull(cus);
		
		cusfind = dao.selectByPk(id);
		logger.debug("Test - 2-  Customer find-------------------");
		logger.debug("Customer found--" +cusfind.getName());		
		Assert.assertNotNull(cusfind);
		
			
		Customer cusUp = new Customer();
		cusUp.setName("amit_Update");
		cusUp.setEmail("amitthapar123@gmail.com_Update");
		cusUp.setId(new ObjectId());
		cusUp.setMobile(new Long("08803010194"));
		
		id = dao.update(cusUp);
		logger.debug("Test - 3- Customer UPDATED = " + cusUp.getName());
		
		cusfind = dao.selectByPk(id);
		logger.debug("Test - 4-  Customer find updated-------------"+cusfind);
		logger.debug("Customer found Updated--" +cusfind.getName());		
		Assert.assertNotNull(cusfind);
		
		
		logger.debug("Test - 5-  Customer delete-------------------");
		Customer cusDel = null;
		cusDel = dao.selectByPk(id);
		dao.delete(cusDel);
		logger.debug("Test - 5-  Customer deleted------------------");
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
