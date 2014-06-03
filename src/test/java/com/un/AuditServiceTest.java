package com.un;

import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.un.domain.Audit;
import com.un.domain.Registration;
import com.un.domain.Schedule;
import com.un.services.AuditService;
import com.un.services.RegistrationService;

public class AuditServiceTest extends RegistrationDaoTest{
	
	private static final Logger logger = Logger.getLogger(AuditServiceTest.class);
	
	@Autowired
	private AuditService<Audit> auditService;
	@Autowired
	
	
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
		super.setUp();
		BasicConfigurator.configure();

		auditService = (AuditService<Audit>) MyTestApplicationContext
				.getInstance().getBean("auditService");

	}

}
