package com.appointment.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Customer;

@Component
public class CustomerBOImpl extends AbstractBaseBO implements IBaseBO<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CustomerBOImpl.class);
	@Autowired
	private BaseDao<Customer> baseDao;

	public Customer add(Customer customer) {
		logger.debug("Adding customer instance");
		return baseDao.insert(customer);
	}

	public Customer get(ObjectId id) {
		logger.debug("Getting stored customer instance");
		return baseDao.selectByPk(id, Customer.class);
	}

	@Override
	public List<Customer> getAll() {

		return baseDao.findAll(Customer.class);
	}

}
