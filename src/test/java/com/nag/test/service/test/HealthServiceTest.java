package com.nag.test.service.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nag.test.dto.Database;
import com.nag.test.service.HealthService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
@Transactional
public class HealthServiceTest {

	/** The health service. */
	@Autowired
	private HealthService healthService;
	
	/** The url. */
	private String url;
	
	/**
	 * On set up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void onSetUp() throws Exception {
		url = "jdbc:mysql://10.23.152.166:3306/nfl";
	}
	
    /**
     * Test get user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetUser() throws Exception {
        Database database = healthService.getDatabaseStats(url);
        System.out.println(database.getMessage()+"**");
    }

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		url = null;
	}

}
