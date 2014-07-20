package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.appointment.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractBaseDao implements
		BaseDao<Customer> {

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

	@Override
	public ObjectId update(Customer entity) {
		Query queryCustomerUpdate = new Query();
		Long mobileNo = entity.getMobile();
		queryCustomerUpdate.addCriteria(Criteria.where("mobile").is(mobileNo));
		Customer customerDbValue = mongoTemplate.findOne(queryCustomerUpdate,
				Customer.class);
		//TODO Find Generic API to find delta to update the DB entity
		if (!StringUtils.isEmpty(entity.getEmail())) {
			if (!entity.getEmail().equalsIgnoreCase(customerDbValue.getEmail())) {
				customerDbValue.setEmail(entity.getEmail());
			}
		}
		mongoTemplate.save(customerDbValue);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer entity) {
		// TODO Need to identify what will be unique key to delete
		Query queryCustomerDelete = new Query();
		queryCustomerDelete.addCriteria(Criteria.where("email").exists(true));
		mongoTemplate.remove(queryCustomerDelete, Customer.class);
	}

}
