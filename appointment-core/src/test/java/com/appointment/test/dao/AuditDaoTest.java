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
import com.appointment.domain.Audit;

public class AuditDaoTest {

	private static final Logger logger = Logger
			.getLogger(AuditDaoTest.class);
	static Process p = null;
	@Autowired
	private BaseDao<Audit> dao;
	
	protected ObjectId id = null;

	@Before
	public void setUp() throws Exception {
		// @Todo Run mongo with a test specific .js file to produce initial data
		// state
		logger.info("setting up test");
		BasicConfigurator.configure();

		dao = (BaseDao<Audit>) MyTestApplicationContext
				.getInstance().getBean("auditDao");
	}

	
	@Test
	public void testInsertFindUpdateDeleteAudit() throws Exception
	{
		Audit audfind = null;
		Audit aud = new Audit();
		
		aud.setAction("Audit");
		aud.setActionBy("Amit");
		aud.setActionCreationDate(new Date());
		aud.setDescription("Audit Description");
		aud.setEntityName("Audit");
		aud.setId(new ObjectId());
		
		id = dao.insert(aud);
		 
		logger.debug("Test - 1- Audit inserted = " + aud.getDescription());
		Assert.assertNotNull(aud);
		
		audfind = dao.selectByPk(id);
		logger.debug("Test - 2-  Audit find-------------------");
		logger.debug("Audit found--" +audfind.getEntityName());		
		Assert.assertNotNull(audfind);
		
			
		Audit audUp = new Audit();
	
		audUp.setAction("Audit_Update");
		audUp.setActionBy("Amit_Update");
		audUp.setActionCreationDate(new Date());
		audUp.setDescription("Audit Description_Update");
		audUp.setEntityName("Audit_Update");
		audUp.setId(new ObjectId());
		id = dao.update(audUp);
		
		logger.debug("Test - 3- Audit UPDATED = " + audUp.getDescription());
		
		audfind = dao.selectByPk(id);
		logger.debug("Test - 4-  Audit find updated-------------"+audfind);
		logger.debug("Audit found Updated--" +audfind.getEntityName());		
		Assert.assertNotNull(audfind);
		
		
		logger.debug("Test - 5-  Audit delete-------------------");
		Audit audDel = null;
		audDel = dao.selectByPk(id);
		dao.delete(audDel);
		logger.debug("Test - 5-  Audit deleted------------------");
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
