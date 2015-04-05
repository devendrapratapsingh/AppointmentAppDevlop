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
import com.appointment.services.BaseService;
import com.appointment.test.dao.MyTestApplicationContext;

public class AuditServiceTest {

	private static final Logger logger = Logger
			.getLogger(AuditServiceTest.class);

	@Autowired
	private BaseService<Audit> auditService;

	@Test
	public void addAudit() throws Exception {
		Audit savedAudit = null;
		Audit audit = new Audit();
		audit.setAction("Add");
		audit.setActionBy("Devendra");
		audit.setActionCreationDate(new Date());
		audit.setDescription("created audit for test");
		audit.setEntityName("Reservation");
		audit.setId(new ObjectId());
		savedAudit = auditService.add(audit);
		logger.debug("audit =" + savedAudit);

		audit = (Audit) auditService.get(savedAudit.getId());
		logger.debug("schedule = " + audit);
		Assert.assertNotNull(audit);
	}

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		logger.info("setting up test");
		// super.setUp();
		BasicConfigurator.configure();

		auditService = (BaseService<Audit>) MyTestApplicationContext
				.getInstance().getBean("auditService");

	}

}
