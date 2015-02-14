package com.appointment.dao;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.appointment.domain.Audit;

@Repository("auditDao")
public class AuditDaoImpl extends AbstractBaseDao implements BaseDao<Audit>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Audit selectByPk(ObjectId id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, Audit.class);
	}

	public ObjectId insert(Audit audit) {
		mongoTemplate.save(audit);
		return audit.getId();
	}

	@Override
	public ObjectId update(Audit entity) {

		ApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
		
		MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
		
		Query searchUserQuery = new Query(Criteria.where("id") .is (entity.getId().toString()));
		
		mongoOperation.remove(searchUserQuery, Audit.class);
		
		entity.setId(new ObjectId());
		
		mongoOperation.save(entity);
		
		return entity.getId();
		
	}

	@Override
	public void delete(Audit entity) {
		
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
				
		MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
				
		Query searchUserQuery = new Query(Criteria.where("id") .is (entity.getId().toString()));
				
		mongoOperation.remove(searchUserQuery, Audit.class);				
		
	}

}
