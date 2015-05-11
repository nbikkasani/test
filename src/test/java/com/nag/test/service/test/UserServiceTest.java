package com.nag.test.service.test;

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

import com.nag.test.dto.UserData;
import com.nag.test.dto.UserPaginationDetails;
import com.nag.test.pojo.User;
import com.nag.test.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback=false)
@Transactional
public class UserServiceTest {

	/** The user service. */
	@Autowired
	private UserService userService;
	
	/** The username. */
	private String username;
	
	/** The city. */
	private String city;
	
	/** The page size. */
	private Integer pageSize;
	
	/** The current page. */
	private Integer currentPage;
	
	/**
	 * On set up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void onSetUp() throws Exception {
		username = "nag";
		city = "reno";
		pageSize = 1;
		currentPage = 2; 
	}
	
   // @Test
    /**
    * Test get user.
    *
    * @throws Exception the exception
    */
   public void testGetUser() throws Exception {
        User user = userService.getUser(username);
        System.out.println(user.toString()+"** Got User for "+username);
    }

    //@Test
    /**
     * Test get users by city.
     *
     * @throws Exception the exception
     */
    public void testGetUsersByCity() throws Exception {
        List<User> users = userService.getUsersByCity(city);
        for(User user:users)
        System.out.println(user.toString()+"*Got Users for city*"+city);
    }
    
    /**
     * Test get users by page.
     *
     * @throws Exception the exception
     */
   // @Test
    public void testGetUsersByPage() throws Exception {
        UserPaginationDetails userPaginationDetails = userService.getUsers(pageSize, currentPage);
        for(UserData user:userPaginationDetails.getUserData())
        System.out.println(user.toString()+"* Got Users for page Size*"+pageSize+"**"+currentPage);
    }
    
    @Test
    /**
    * Test get users count.
    *
    * @throws Exception the exception
    */
   public void testGetUsersCount() throws Exception {
        Integer usersCount = userService.getUsersCount();
    	       System.out.println(usersCount+"* users total*");

    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
	public void tearDown() throws Exception {
		username = null;
		city = null;
		pageSize = null;
		currentPage = null; 
	}
    
}
