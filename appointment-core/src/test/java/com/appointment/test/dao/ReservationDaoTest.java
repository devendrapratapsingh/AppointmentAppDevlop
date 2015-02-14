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
import com.appointment.domain.Customer;
import com.appointment.domain.Reservation;

public class ReservationDaoTest {
	private static final Logger logger = Logger
			.getLogger(ReservationDaoTest.class);
	static Process p = null;
	@Autowired
	private BaseDao<Reservation> dao;
	
	protected ObjectId id = null;

	@Before
	public void setUp() throws Exception {
		// @Todo Run mongo with a test specific .js file to produce initial data
		// state
		logger.info("setting up test");
		BasicConfigurator.configure();

		dao = (BaseDao<Reservation>) MyTestApplicationContext
				.getInstance().getBean("reservationDao");
	}

	
	@Test
	public void testInsertFindUpdateDeleteReservation() throws Exception
	{
		Reservation resfind = null;
		Reservation res = new Reservation();
		Customer cus = new Customer();
		
		cus.setName("amit");
		cus.setEmail("amitthapar123@gmail.com");
		cus.setId(new ObjectId());
		cus.setMobile(new Long("08803010194"));	
		
		res.setCustomer(cus);
		res.setCreateDate(new Date());
		res.setDurationId(new Long("4"));
		res.setId(new ObjectId());
		res.setReservationDate(new Date());
		res.setReservationId(new Long(1));
		
		id = dao.insert(res);
		 
		logger.debug("Test - 1- Reservation inserted = " + res.getCustomer().getName());
		Assert.assertNotNull(res);
		
		resfind = dao.selectByPk(id);
		logger.debug("Test - 2-  Reservation find-------------------");
		logger.debug("Reservation found--" +resfind.getCustomer().getName());		
		Assert.assertNotNull(resfind);
		
		Customer cusUp = new Customer();
		
		cusUp.setName("amit_Update");
		cusUp.setEmail("amitthapar123@gmail.com_Update");
		cusUp.setId(new ObjectId());
		cusUp.setMobile(new Long("08803010194"));	
			
		Reservation resUp = new Reservation();
		resUp.setCustomer(cusUp);
		resUp.setCreateDate(new Date());
		resUp.setDurationId(new Long("5"));
		resUp.setId(new ObjectId());
		resUp.setReservationDate(new Date());
		resUp.setReservationId(new Long(2));
		
		id = dao.update(resUp);
		logger.debug("Test - 3- Reservation UPDATED = " + resUp.getCustomer().getName());
		
		resfind = dao.selectByPk(id);
		logger.debug("Test - 4-  Reservation find updated-------------");
		logger.debug("Reservation found Updated--" +resfind.getCustomer().getName());		
		Assert.assertNotNull(resfind);
		
		
		logger.debug("Test - 5-  Reservation delete-------------------");
		Reservation resDel = null;
		resDel = dao.selectByPk(id);
		dao.delete(resDel);
		logger.debug("Test - 5-  Reservation deleted------------------");
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
