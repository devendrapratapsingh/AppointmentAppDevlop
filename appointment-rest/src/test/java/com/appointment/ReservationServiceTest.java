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

import com.appointment.domain.Customer;
import com.appointment.domain.Reservation;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

public class ReservationServiceTest {
	
	static Process p = null;
	@Autowired
	private BaseService<Reservation> service;

	protected ObjectId id = null;

	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();

		service = (BaseService<Reservation>) MyTestApplicationContext.getInstance()
				.getBean("reservationService");
	}

	@Test
	public void testReservation_Insert() {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = service.add(Reservation);

		Reservation insertedRes = service.get(insertedReservation.getId());
		Assert.assertNotNull(" Reservation inserted", insertedRes);
	}

	@Test
	public void testReservation_Delete() {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = service.add(Reservation);

		Reservation insertedRes = service
				.get(Reservation.getId());
		service.remove(insertedRes, Reservation.class);
		Reservation deleteRes = service.get(insertedReservation.getId());
		Assert.assertNull("Reservation deleted", deleteRes);
	}

	@Test
	public void testReservation_Find() {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = service.add(Reservation);

		Reservation fetchRes = service.get(insertedReservation.getId());
		Assert.assertTrue("fetched and created should be same", fetchRes
				.getId().equals(Reservation.getId()));
	}

	@Test
	public void testReservation_FindAll() {
		Reservation Reservation = createReservation();

		List<Reservation> fetched = service.getAll(Reservation.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testReservation_CountAll() {
		Reservation Reservation = createReservation();

		long recordCount = service.countAll(Reservation.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}
	

	@Test
	public void testReservation_Update() {
		Reservation Reservation = createReservation();

		Reservation insertedReservation = service.add(Reservation);
		insertedReservation.setDurationId(new Long(2));
		Reservation fetchRes = service.modify(insertedReservation);
		Assert.assertTrue("fetched and created should be same", fetchRes
				.getId().equals(insertedReservation.getId()));
	}
	
	

	private Reservation createReservation() {
		Reservation Reservation = new Reservation();
		Customer cus = this.createCustmer();
		Reservation.setCustomer(cus);
		Reservation.setCreateDate(new Date());
		Reservation.setDurationId(new Long(1));
		Reservation.setId(new ObjectId());
		Reservation.setReservationDate(new Date());
		Reservation.setReservationId(new Long(1));
		
		return Reservation;
	}
	
	private Customer createCustmer() {
		Customer customer = new Customer();
		customer.setName("amit");
		customer.setEmail("amitthapar123@gmail.com");
		customer.setId(new ObjectId());
		customer.setMobile(new Long("08803010194"));
		return customer;
	}


	// @BeforeClass
	public static void beforeClass() throws Exception {

		String[] command = new String[] {
				"/D:/amit/software/mongoDB/bin/mongod", "--dbpath",
				"/D:/amit/software/mongoDB/data", "--rest" };

		ProcessBuilder pb = new ProcessBuilder(command);

		p = pb.start();

		
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
					} catch (IllegalThreadStateException itse) {
					processClosed = false;
				}
			}
		}

	}

	
}
