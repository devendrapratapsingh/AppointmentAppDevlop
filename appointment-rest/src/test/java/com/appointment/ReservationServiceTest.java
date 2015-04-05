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
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

public class ReservationServiceTest {

	@Autowired
	private BaseService<Reservation> reservationService;
	@Autowired
	private static final Logger logger = Logger
			.getLogger(ReservationServiceTest.class);

	@Test
	public void addAudit() throws Exception {
		Reservation savedReservation = null;
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
		savedReservation = reservationService.add(reservation);
		logger.debug("reservation.id =" + savedReservation.getId());

		reservation = (Reservation) reservationService.get(savedReservation
				.getId());
		logger.debug("reservation = " + reservation);
		Assert.assertNotNull(reservation);
	}

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		// super.setUp();
		BasicConfigurator.configure();

		reservationService = (BaseService<Reservation>) MyTestApplicationContext
				.getInstance().getBean("reservationService");

	}

}
