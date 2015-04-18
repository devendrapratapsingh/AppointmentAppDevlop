package com.appointment;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.domain.Customer;
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

public class CustomerServiceTest {

	private static final Logger logger = Logger
			.getLogger(CustomerServiceTest.class);
	static Process p = null;
	@Autowired
	private BaseService<Customer> service;
	
	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();

		service = (BaseService<Customer>) MyTestApplicationContext.getInstance()
				.getBean("customerService");
	}

	@Test
	public void testCustomer_Insert() {
		Customer customer = createCustomer();

		Customer insertedCustomer = service.add(customer);

		Customer insertedCust = service.get(insertedCustomer.getId());
		Assert.assertNotNull(" Customer inserted", insertedCust);
	}

	@Test
	public void testCustomer_Delete() {
		Customer customer = createCustomer();

		Customer insertedCustomer = service.add(customer);

		Customer insertedCust = service
				.get(customer.getId());
		service.remove(insertedCust, Customer.class);
		Customer deleteCust = service.get(insertedCustomer.getId());
		Assert.assertNull("Customer deleted", deleteCust);
	}

	@Test
	public void testCustomer_Find() {
		Customer customer = createCustomer();

		Customer insertedCustomer = service.add(customer);

		Customer fetchCust = service.get(insertedCustomer.getId());
		Assert.assertTrue("fetched and created should be same", fetchCust
				.getId().equals(customer.getId()));
	}

	@Test
	public void testCustomer_FindAll() {
		Customer customer = createCustomer();

		List<Customer> fetched = service.getAll(Customer.class);

		Assert.assertTrue("fetched size should be greater than zero",
				fetched.size() > 0);
	}

	@Test
	public void testCustomer_CountAll() {
		Customer customer = createCustomer();

		long recordCount = service.countAll(Customer.class);

		Assert.assertTrue("fetched size should be greater than zero",
				recordCount > 0);
	}

	@Test
	public void testCustomer_Update() {
		Customer customer = createCustomer();

		customer.setName("Devendra");

		Customer fetchCust = service.modify(customer);
		Assert.assertTrue("fetched and created should be same", fetchCust
				.getId().equals(customer.getId()));
	}

	private Customer createCustomer() {
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
