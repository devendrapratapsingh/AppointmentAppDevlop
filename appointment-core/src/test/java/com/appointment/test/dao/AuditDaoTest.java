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
import com.appointment.domain.Audit;

public class AuditDaoTest {

	private static final Logger logger = Logger.getLogger(AuditDaoTest.class);
	static Process p = null;
	@Autowired
	private BaseDao<Audit> dao;

	@Before
	public void setUp() throws Exception {
		// @Todo Run mongo with a test specific .js file to produce initial data
		// state
		BasicConfigurator.configure();

		dao = (BaseDao<Audit>) MyTestApplicationContext.getInstance().getBean(
				"auditDao");
	}
	
	@Test
	public void testAudit_Insert() {
		Audit Audit = createAudit();

		Audit insertedAudit = dao.insert(Audit);

		Audit insertedAud = dao.selectByPk(insertedAudit.getId(),
				Audit.class);
		Assert.assertNotNull(" Audit inserted", insertedAud);
	}


	@Test
	public void testAudit_Find() {
		Audit Audit = createAudit();

		Audit insertedAudit = dao.insert(Audit);

		Audit fetchAud = dao.selectByPk(insertedAudit.getId(),
				Audit.class);
		Assert.assertTrue("fetched and created should be same", fetchAud
				.getId().equals(Audit.getId()));
	}

	@Test
	public void testAudit_FindAll() {
		Audit Audit = createAudit();

		List<Audit> fetched = dao.findAll(Audit.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testAudit_CountAll() {
		Audit Audit = createAudit();

		long recordCount = dao.countAll(Audit.class);

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
