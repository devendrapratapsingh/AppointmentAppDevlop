package com.appointment.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractBaseDao<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Customer update(Customer entity) {

		Query queryCustomerUpdate = new Query();
		Long mobileNo = entity.getMobile();
		queryCustomerUpdate.addCriteria(Criteria.where("mobile").is(mobileNo));
		Customer storedCustomer = mongoTemplate.findOne(queryCustomerUpdate,
				Customer.class);
		entity.setId(storedCustomer.getId());
		BeanUtils.copyProperties(entity, storedCustomer);
		mongoTemplate.save(storedCustomer);
		return entity;

	}

}
