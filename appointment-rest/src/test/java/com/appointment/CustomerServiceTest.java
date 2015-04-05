package com.appointment;

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

	@Autowired
	private BaseService<Customer> customerService;

	@Autowired
	@Test
	public void addCustomer() throws Exception {
		Customer savedCustomer = null;
		Customer customer = new Customer();
		customer.setEmail("testP@test.com");
		customer.setId(new ObjectId());
		customer.setMobile(new Long(0647532423));
		;
		customer.setName("ParagShri");

		savedCustomer = customerService.add(customer);
		logger.debug("customer =" + savedCustomer);

		customer = (Customer) customerService.get(savedCustomer.getId());
		logger.debug("schedule = " + customer);
		Assert.assertNotNull(customer);
	}

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		BasicConfigurator.configure();

		customerService = (BaseService<Customer>) MyTestApplicationContext
				.getInstance().getBean("customerService");

	}

}
