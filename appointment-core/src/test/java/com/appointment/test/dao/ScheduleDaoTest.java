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
import com.appointment.domain.Config;
import com.appointment.domain.Schedule;

public class ScheduleDaoTest {
	
	private static final Logger logger = Logger
			.getLogger(ScheduleDaoTest.class);
	static Process p = null;
	@Autowired
	private BaseDao<Schedule> dao;
	
	protected ObjectId id = null;

	@Before
	public void setUp() throws Exception {
		// @Todo Run mongo with a test specific .js file to produce initial data
		// state
		logger.info("setting up test");
		BasicConfigurator.configure();

		dao = (BaseDao<Schedule>) MyTestApplicationContext
				.getInstance().getBean("scheduleDao");
	}

	
	@Test
	public void testInsertFindUpdateDeleteSchedule() throws Exception
	{
		Schedule schfind = null;
		
		Schedule sch = new Schedule();
		Config config = new Config();
		config.setEndHr("endHr");
		config.setFrequency("frequency");
		config.setMinSlotPerResource("minSlotPerResource");
		config.setResources("resources");
		config.setStartHr("startHr");
		
		
		sch.setConfig(config);
		sch.setDuration("1");
		sch.setDurationId(new Long(2));
		sch.setId(id);
		sch.setResourceCount("resourceCount");
		sch.setStatus("SCHEDULED");
		sch.setThreshold("threshold");
		
		
		id = dao.insert(sch);
		 
		logger.debug("Test - 1- Schedule inserted = " + sch.getStatus());
		Assert.assertNotNull(sch);
		
		schfind = dao.selectByPk(id);
		logger.debug("Test - 2-  Schedule find-------------------");
		logger.debug("Schedule found--" +schfind.getDuration());		
		Assert.assertNotNull(schfind);
		
			
		Schedule schUp = new Schedule();
		schUp.setConfig(config);
		schUp.setDuration("2");
		schUp.setDurationId(new Long(2));
		schUp.setId(id);
		schUp.setResourceCount("resourceCount");
		schUp.setStatus("SCHEDULED");
		schUp.setThreshold("threshold");
		
		id = dao.update(schUp);
		logger.debug("Test - 3- Schedule UPDATED = " + schUp.getDuration());
		
		schfind = dao.selectByPk(id);
		logger.debug("Test - 4-  Schedule find updated-------------");
		logger.debug("Schedule found Updated--" +schfind.getStatus());		
		Assert.assertNotNull(schfind);
		
		
		logger.debug("Test - 5-  Schedule delete-------------------");
		Schedule schDel = null;
		schDel = dao.selectByPk(id);
		dao.delete(schDel);
		logger.debug("Test - 5-  Schedule deleted------------------");
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
