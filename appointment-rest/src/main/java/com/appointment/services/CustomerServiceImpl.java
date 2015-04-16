package com.appointment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.BaseBO;
import com.appointment.domain.Customer;

@Service("customerService")
public class CustomerServiceImpl implements BaseService<Customer> {

	private static final Logger logger = Logger
			.getLogger(CustomerServiceImpl.class);
	@Autowired
	private BaseBO<Customer> baseBO;

	@Override
	public Customer get(ObjectId id) {
		logger.debug("Getting a stored Customer instance");
		Customer customer = baseBO.get(id, Customer.class);
		return customer;
	}
	@Override
	public Customer add(Customer cus) {
		logger.debug("Adding a new Customer instance");
		Customer customer = baseBO.add(cus);
		return customer;
	}
	@Override
	public Customer modify(Customer cus) {
		logger.debug("Modifying the customer instance");
		Customer customer = baseBO.add(cus);
		return customer;
	}

	@Override
	public List<Customer> getAll(Class<Customer> entityClass) {
		logger.debug("Getting all the customers");
		List<Customer> fetched = baseBO.getAll(Customer.class);
		return fetched;
	}
	@Override
	public Long countAll(Class<Customer> entityClass) {
		logger.debug("Counting the customers");
		long recordCount = baseBO.countAll(Customer.class);
		return recordCount;
	}
	@Override
	public void remove(Customer entity, Class<Customer> entityClass) {
		logger.debug("removing the customer");
		baseBO.remove(entity, entityClass);
	
	}

}
