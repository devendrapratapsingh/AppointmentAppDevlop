package com.appointment.test.dao;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
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
		BasicConfigurator.configure();

		dao = (BaseDao<Schedule>) MyTestApplicationContext.getInstance()
				.getBean("scheduleDao");
	}

	
	@Test
	public void testSchedule_Insert() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = dao.insert(Schedule);

		Schedule insertedSch = dao.selectByPk(insertedSchedule.getId(),
				Schedule.class);
		Assert.assertNotNull(" Schedule inserted", insertedSch);
	}

	@Test
	public void testSchedule_Delete() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = dao.insert(Schedule);

		Schedule insertedSch = dao
				.selectByPk(Schedule.getId(), Schedule.class);
		dao.delete(insertedSch, Schedule.class);
		Schedule deleteSch = dao.selectByPk(insertedSchedule.getId(),
				Schedule.class);
		Assert.assertNull("Schedule deleted", deleteSch);
	}

	@Test
	public void testSchedule_Find() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = dao.insert(Schedule);

		Schedule fetchSch = dao.selectByPk(insertedSchedule.getId(),
				Schedule.class);
		Assert.assertTrue("fetched and created should be same", fetchSch
				.getId().equals(Schedule.getId()));
	}

	@Test
	public void testSchedule_FindAll() {
		Schedule Schedule = createSchedule();

		List<Schedule> fetched = dao.findAll(Schedule.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testSchedule_CountAll() {
		Schedule Schedule = createSchedule();

		long recordCount = dao.countAll(Schedule.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}
	

	@Test
	public void testSchedule_Update() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = dao.insert(Schedule);
		insertedSchedule.setDurationId(new Long(2));
		Schedule fetchSch = dao.update(insertedSchedule);
		Assert.assertTrue("fetched and created should be same", fetchSch
				.getId().equals(insertedSchedule.getId()));
	}
	
	

	private Schedule createSchedule() {
		Schedule schedule = new Schedule();
		schedule.setConfig(this.createConfig());
		schedule.setDuration("1");
		schedule.setDurationId(new Long(1));
		schedule.setId(new ObjectId());
		schedule.setResourceCount("count");
		schedule.setStatus("status");
		schedule.setThreshold("Threshold");
			
		return schedule;
	}
	
	private Config createConfig() {
		Config config = new Config();
		config.setEndHr("8");
		config.setFrequency("frequency");
		config.setMinSlotPerResource("1");
		config.setResources("Test");
		config.setStartHr("1");
		
		return config;
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
