package com.un.dao;


import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author x075093
 *
 */
@Component
public abstract class AbstractBaseDao implements Serializable {
	
     @Autowired   	
	 protected MongoTemplate mongoTemplate;

	    public void setMongoTemplate(MongoTemplate template) {
	        this.mongoTemplate = template;
	    }

	    public MongoTemplate getMongoTemplate() {
	        return this.mongoTemplate;
	    }
}
