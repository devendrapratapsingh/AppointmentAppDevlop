package com.appointment;

import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.appointment.domain.Audit;
import com.appointment.services.AuditService;
import com.appointment.test.dao.MyTestApplicationContext;

public class AuditServiceTest {
	
	private static final Logger logger = Logger.getLogger(AuditServiceTest.class);
	
	@Autowired
	private AuditService<Audit> auditService;
	
	
	@Test
	public void addAudit() throws Exception {
		ObjectId id = null;
		Audit audit = new Audit();
		audit.setAction("Add");
		audit.setActionBy("Devendra");
		audit.setActionCreationDate(new Date());
		audit.setDescription("created audit for test");
		audit.setEntityName("Reservation");
		audit.setId(new ObjectId());
		id = auditService.addAudit(audit);
		logger.debug("audit.id =" + id);

		audit = (Audit) auditService.get(id);
		logger.debug("schedule = " + audit);
		Assert.assertNotNull(audit);
	}
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		//super.setUp();
		BasicConfigurator.configure();

		auditService = (AuditService<Audit>) MyTestApplicationContext
				.getInstance().getBean("auditService");

	}

}
