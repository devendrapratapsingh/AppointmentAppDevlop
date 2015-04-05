package com.appointment;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.bo.IBaseBO;
import com.appointment.domain.Registration;
import com.appointment.domain.Schedule;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

@SuppressWarnings("deprecation")
public class ScheduleServiceTest {

	private static final Logger logger = Logger
			.getLogger(ScheduleServiceTest.class);
	@Autowired
	private BaseService<Schedule> service;
	@Autowired
	private IBaseBO<Registration> iBaseBO;

	@Test
	public void addSchedule() throws Exception {
		Schedule savedSchedule = null;
		Schedule schedule = new Schedule();
		schedule.setDurationId(1L);
		schedule.setStatus("A");
		savedSchedule = service.add(schedule);
		logger.debug("log.id =" + savedSchedule.getId());

		schedule = (Schedule) service.get(savedSchedule.getId());
		logger.debug("schedule = " + schedule);
		Assert.assertNotNull(schedule);
	}

	@Test
	public void duplicateRecord() throws Exception {

		BasicConfigurator.configure();

		/*
		 * ObjectId id = null;
		 * 
		 * Registration registration = new Registration();
		 * registration.setId(new ObjectId());
		 * registration.setOrgName("UniqueNotion");
		 * registration.setOrgPrefix("UN");
		 * registration.setEmail("test@test.com");
		 * registration.setContact("+31647608916");
		 * registration.setCreatedBy("Parag2");
		 * registration.setCreateTimestamp(new Date()); id =
		 * service.add(registration); registration = new Registration();
		 * registration.setId(new ObjectId());
		 * registration.setOrgName("UniqueNotion");
		 * registration.setOrgPrefix("UN");
		 * registration.setEmail("test@test.com");
		 * registration.setContact("+31647608916");
		 * registration.setCreatedBy("Parag2");
		 * registration.setCreateTimestamp(new Date()); id =
		 * service.add(registration); logger.debug("log.id =" + id);
		 * 
		 * registration = (Registration) service.get(id);
		 * logger.debug("registration = " + registration);
		 */
		// Assert.assertNull(registration);
	}

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");

		BasicConfigurator.configure();

		service = (BaseService<Schedule>) MyTestApplicationContext
				.getInstance().getBean("scheduleService");

	}
}
