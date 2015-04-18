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

import com.appointment.domain.Audit;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

public class AuditServiceTest {

	private static final Logger logger = Logger.getLogger(AuditServiceTest.class);
	static Process p = null;
	@Autowired
	private BaseService<Audit> service;

	@Before
	public void setUp() throws Exception {
		
		BasicConfigurator.configure();
		service = (BaseService<Audit>) MyTestApplicationContext.getInstance().getBean(
				"auditService");
	}
	
	@Test
	public void testAudit_Insert() {
		Audit Audit = createAudit();

		Audit insertedAudit = service.add(Audit);

		Audit insertedAud = service.get(insertedAudit.getId());
		Assert.assertNotNull(" Audit inserted", insertedAud);
	}


	@Test
	public void testAudit_Find() {
		Audit Audit = createAudit();

		Audit insertedAudit = service.add(Audit);

		Audit fetchAud = service.get(insertedAudit.getId());
		Assert.assertTrue("fetched and created should be same", fetchAud
				.getId().equals(Audit.getId()));
	}

	@Test
	public void testAudit_FindAll() {
		Audit Audit = createAudit();

		List<Audit> fetched = service.getAll(Audit.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testAudit_CountAll() {
		Audit Audit = createAudit();

		long recordCount = service.countAll(Audit.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}

	private Audit createAudit() {
		Audit Audit = new Audit();
		Audit.setAction("Test Audit Action");
		Audit.setActionBy("Amit");
		Audit.setActionCreationDate(new Date());
		Audit.setDescription("Test Audit Action");
		Audit.setEntityName("Audit");
		Audit.setId(new ObjectId());
		return Audit;
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
