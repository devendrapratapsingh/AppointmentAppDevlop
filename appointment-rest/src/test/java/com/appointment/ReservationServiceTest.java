package com.appointment;

import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.domain.Customer;
import com.appointment.domain.Reservation;
import com.appointment.services.ReservationService;
import com.appointment.test.dao.MyTestApplicationContext;
import com.appointment.test.dao.RegistrationDaoTest;

public class ReservationServiceTest extends RegistrationDaoTest {
	
	@Autowired
	private ReservationService<Reservation> reservationService;
	@Autowired
	
	private static final Logger logger = Logger
	.getLogger(ReservationServiceTest.class);
	
	@Test
	public void addAudit() throws Exception {
		ObjectId id = null;
		Reservation reservation = new Reservation();
		reservation.setCreateDate(new Date());
		Customer customer = new Customer();
		customer.setEmail("test@test.com");
		customer.setId(new ObjectId());
		customer.setMobile(new Long(067364323));
		customer.setName("Chandulal");
		reservation.setCustomer(customer);
		reservation.setDurationId(new Long(1L));
		reservation.setId(new ObjectId());
		reservation.setReservationDate(new Date());
		reservation.setReservationId(new Long(1L));
		logger.debug("reservation = " + reservation);
		id = reservationService.add(reservation);
		logger.debug("reservation.id =" + id);

		reservation = (Reservation) reservationService.get(id);
		logger.debug("reservation = " + reservation);
		Assert.assertNotNull(reservation);
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		super.setUp();
		BasicConfigurator.configure();

		reservationService = (ReservationService<Reservation>) MyTestApplicationContext
				.getInstance().getBean("reservationService");

	}

}
