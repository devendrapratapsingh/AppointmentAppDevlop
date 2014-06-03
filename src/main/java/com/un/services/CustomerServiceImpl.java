package com.un.services;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.un.bo.IBaseBO;
import com.un.domain.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService<Customer> {

	private static final Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	@Autowired
	private IBaseBO<Customer> baseBO;

	/**
	 * @return the baseBO
	 */
	public IBaseBO<Customer> getBaseBO() {
		return baseBO;
	}

	/**
	 * @param baseBO the baseBO to set
	 */
	public void setBaseBO(IBaseBO<Customer> baseBO) {
		this.baseBO = baseBO;
	}

	public Customer get(ObjectId id) {
		logger.debug("Getting a stored Customer instance");
		return baseBO.get(id);
	}

	public ObjectId addCustomer(Customer customer) {
		logger.debug("Adding a new Customer instance");
		return baseBO.add(customer);
	}

}
