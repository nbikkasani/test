package com.nag.test.dao.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.nag.test.dao.UserDao;
import com.nag.test.dto.UserDataGroup;
import com.nag.test.pojo.User;


// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
@Transactional
public class UserDaoTest {

	
	/** The user dao. */
	@Autowired
	private UserDao userDao;
	
	/** The user name. */
	private String userName;
	
	private String city;
	
	/**
	 * On set up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void onSetUp() throws Exception {
		userName = "nag";
		city = "reno";
	}
	
    /**
     * Test get user by user name.
     */
    @Test
    public void testGetUserByUserName() {
        User user = userDao.getUser(userName);
        System.out.println(user.getCity()+"**");
    }
    
    /**
     * Test user data group.
     */
    @Test
    public void testUserDataGroup() {
        List<UserDataGroup> userDataGroups = userDao.getUserDataByGroup(city);
        for(UserDataGroup userDataGroup : userDataGroups)
        System.out.println(userDataGroup.getGender()+"**"+userDataGroup.getCount());
    }


	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		userName = null;
	}

}
