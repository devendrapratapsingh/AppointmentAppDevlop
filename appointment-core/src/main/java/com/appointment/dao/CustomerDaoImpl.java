package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractBaseDao implements BaseDao<Customer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public Customer selectByPk(ObjectId id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, Customer.class);
	}

	public ObjectId insert(Customer customer) {
		mongoTemplate.save(customer);
		return customer.getId();
	}

}
