package com.appointment.test.dao;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Customer;

public class CustomerDaoTest {

	private static final Logger logger = Logger
			.getLogger(CustomerDaoTest.class);
	static Process p = null;
	@Autowired
	private BaseDao<Customer> dao;

	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();

		dao = (BaseDao<Customer>) MyTestApplicationContext.getInstance()
				.getBean("customerDao");
	}

	@Test
	public void testCustmer_Insert() {
		Customer customer = createCustmer();

		Customer insertedCustomer = dao.insert(customer);

		Customer insertedCust = dao.selectByPk(insertedCustomer.getId(),
				Customer.class);
		Assert.assertNotNull(" Customer inserted", insertedCust);
	}

	@Test
	public void testCustmer_Delete() {
		Customer customer = createCustmer();

		Customer insertedCustomer = dao.insert(customer);

		Customer insertedCust = dao
				.selectByPk(customer.getId(), Customer.class);
		dao.delete(insertedCust, Customer.class);
		Customer deleteCust = dao.selectByPk(insertedCustomer.getId(),
				Customer.class);
		Assert.assertNull("Customer deleted", deleteCust);
	}

	@Test
	public void testCustmer_Find() {
		Customer customer = createCustmer();

		Customer insertedCustomer = dao.insert(customer);

		Customer fetchCust = dao.selectByPk(insertedCustomer.getId(),
				Customer.class);
		Assert.assertTrue("fetched and created should be same", fetchCust
				.getId().equals(customer.getId()));
	}

	@Test
	public void testCustmer_Update() {
		Customer customer = createCustmer();

		customer.setName("Devendra");

		Customer fetchCust = dao.update(customer);
		Assert.assertTrue("fetched and created should be same", fetchCust
				.getId().equals(customer.getId()));
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
