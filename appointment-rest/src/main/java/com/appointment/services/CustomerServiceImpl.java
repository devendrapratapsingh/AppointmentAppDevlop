package com.appointment.services;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.bo.IBaseBO;
import com.appointment.domain.Customer;

@Service("customerService")
public class CustomerServiceImpl implements BaseService<Customer> {

	private static final Logger logger = Logger
			.getLogger(CustomerServiceImpl.class);
	@Autowired
	private IBaseBO<Customer> baseBO;

	/**
	 * @return the baseBO
	 */
	public IBaseBO<Customer> getBaseBO() {
		return baseBO;
	}

	/**
	 * @param baseBO
	 *            the baseBO to set
	 */
	public void setBaseBO(IBaseBO<Customer> baseBO) {
		this.baseBO = baseBO;
	}

	public Customer get(ObjectId id) {
		logger.debug("Getting a stored Customer instance");
		return baseBO.get(id);
	}

	public Customer add(Customer customer) {
		logger.debug("Adding a new Customer instance");
		return baseBO.add(customer);
	}

}
