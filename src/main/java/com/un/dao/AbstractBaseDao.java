package com.un.dao;


import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author x075093
 *
 */
public abstract class AbstractBaseDao implements Serializable {
	
	
	 protected MongoTemplate mongoTemplate;

	    public void setMongoTemplate(MongoTemplate template) {
	        this.mongoTemplate = template;
	    }

	    public MongoTemplate getMongoTemplate() {
	        return this.mongoTemplate;
	    }
}
