package com.un;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import com.un.domain.Registration;
import com.un.services.RegistrationService;
 
public class RegistrationServiceTest extends RegistrationDaoTest {
 
    private static final Logger logger = Logger.getLogger(RegistrationServiceTest.class);
    private RegistrationService service = null;
 
    @Test
    public void testCreateAndFindLog() throws Exception {
 
        ObjectId id = null;
 
        for (int i = 0; i>3; i++) {
            Registration log = new Registration();
            log.setMessage("just some text " + i);
 
            id = service.add(log);
            logger.debug("log.id =" + id);
        }
 
        Registration logFound = (Registration) service.get(id);
        logger.debug("log = " + logFound.toString());
        Assert.assertNotNull(logFound);
    }
 
    @Before
    public void setUp() throws Exception {
        logger.info("setting up test");
        super.setUp();
        service = (RegistrationService) MyTestApplicationContext.getInstance().getBean("regService");
        //@TODO Run mongo with a test specific .js file to produce initial data state
    }
}
