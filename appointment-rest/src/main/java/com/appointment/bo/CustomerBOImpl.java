package com.appointment.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appointment.dao.BaseDao;
import com.appointment.domain.Customer;

@Component
public class CustomerBOImpl extends AbstractBaseBO<Customer>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CustomerBOImpl.class);
	@Autowired
	private BaseDao<Customer> baseDao;

	@Override
	public Customer modify(Customer entity) {

		logger.debug("Update instance");
		return baseDao.update(entity);
		
	}
	
}
