package com.appointment;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.domain.Customer;
import com.appointment.services.CustomerService;
import com.appointment.test.dao.MyTestApplicationContext;

public class CustomerServiceTest {
	
private static final Logger logger = Logger.getLogger(CustomerServiceTest.class);
	
	@Autowired
	private CustomerService<Customer> customerService;
	@Autowired
	
	
	@Test
	public void addCustomer() throws Exception {
		ObjectId id = null;
		Customer customer = new Customer();
		customer.setEmail("testP@test.com");
		customer.setId(new ObjectId());
		customer.setMobile(new Long(0647532423));;
		customer.setName("ParagShri");
		
		id = customerService.addCustomer(customer);
		logger.debug("customer.id =" + id);

		customer = (Customer) customerService.get(id);
		logger.debug("schedule = " + customer);
		Assert.assertNotNull(customer);
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		//super.setUp();
		BasicConfigurator.configure();

		customerService = (CustomerService<Customer>) MyTestApplicationContext
				.getInstance().getBean("customerService");

	}



}
