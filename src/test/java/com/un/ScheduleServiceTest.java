package com.un;

import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.un.bo.IBaseBO;
import com.un.domain.Registration;
import com.un.domain.Schedule;
import com.un.services.RegistrationService;
import com.un.services.ScheduleService;

public class ScheduleServiceTest extends RegistrationDaoTest {

	private static final Logger logger = Logger
			.getLogger(ScheduleServiceTest.class);
	@Autowired
	private ScheduleService<Schedule> service;
	@Autowired
	private IBaseBO<Registration> iBaseBO;

	@Test
	public void addSchedule() throws Exception {
		ObjectId id = null;
		Schedule schedule = new Schedule();
		schedule.setDurationId(1L);
		schedule.setStatus("A");
		id = service.addSchedule(schedule);
		logger.debug("log.id =" + id);

		schedule = (Schedule) service.get(id);
		logger.debug("schedule = " + schedule);
		Assert.assertNotNull(schedule);
	}

	@Test
	public void duplicateRecord() throws Exception {

		BasicConfigurator.configure();

		/*ObjectId id = null;

		Registration registration = new Registration();
		registration.setId(new ObjectId());
		registration.setOrgName("UniqueNotion");
		registration.setOrgPrefix("UN");
		registration.setEmail("test@test.com");
		registration.setContact("+31647608916");
		registration.setCreatedBy("Parag2");
		registration.setCreateTimestamp(new Date());
		id = service.add(registration);
		registration = new Registration();
		registration.setId(new ObjectId());
		registration.setOrgName("UniqueNotion");
		registration.setOrgPrefix("UN");
		registration.setEmail("test@test.com");
		registration.setContact("+31647608916");
		registration.setCreatedBy("Parag2");
		registration.setCreateTimestamp(new Date());
		id = service.add(registration);
		logger.debug("log.id =" + id);

		registration = (Registration) service.get(id);
		logger.debug("registration = " + registration);*/
		//Assert.assertNull(registration);
	}

	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		super.setUp();
		BasicConfigurator.configure();

		service = (ScheduleService<Schedule>) MyTestApplicationContext
				.getInstance().getBean("scheduleService");

	}
}
