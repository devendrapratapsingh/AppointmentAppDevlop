package com.appointment.test.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Audit;

public class AuditDaoTest {

	private static final Logger logger = Logger.getLogger(AuditDaoTest.class);
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

		dao = (BaseDao<Audit>) MyTestApplicationContext.getInstance().getBean(
				"auditDao");
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
