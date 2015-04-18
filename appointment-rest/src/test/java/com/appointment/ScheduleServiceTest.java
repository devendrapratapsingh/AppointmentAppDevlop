package com.appointment;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.domain.Config;
import com.appointment.domain.Registration;
import com.appointment.domain.Schedule;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

@SuppressWarnings("deprecation")
public class ScheduleServiceTest {

	private static final Logger logger = Logger
			.getLogger(ScheduleServiceTest.class);
	static Process p = null;
	@Autowired
	private BaseService<Schedule> service;

	protected ObjectId id = null;
	
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();

		service = (BaseService<Schedule>) MyTestApplicationContext.getInstance()
				.getBean("scheduleService");
	}

	@Test
	public void testSchedule_Insert() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);

		Schedule insertedSch = service.get(insertedSchedule.getId());
		Assert.assertNotNull(" Schedule inserted", insertedSch);
	}

	@Test
	public void testSchedule_Delete() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);

		Schedule insertedSch = service
				.get(Schedule.getId());
		service.remove(insertedSch, Schedule.class);
		Schedule deleteSch = service.get(insertedSchedule.getId());
		Assert.assertNull("Schedule deleted", deleteSch);
	}

	@Test
	public void testSchedule_Find() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);

		Schedule fetchSch = service.get(insertedSchedule.getId());
		Assert.assertTrue("fetched and created should be same", fetchSch
				.getId().equals(Schedule.getId()));
	}

	@Test
	public void testSchedule_FindAll() {
		Schedule Schedule = createSchedule();

		List<Schedule> fetched = service.getAll(Schedule.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testSchedule_CountAll() {
		Schedule Schedule = createSchedule();

		long recordCount = service.countAll(Schedule.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}
	

	@Test
	public void testSchedule_Update() {
		Schedule Schedule = createSchedule();

		Schedule insertedSchedule = service.add(Schedule);
		insertedSchedule.setDurationId(new Long(2));
		Schedule fetchSch = service.modify(insertedSchedule);
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
