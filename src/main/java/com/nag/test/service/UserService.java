package com.nag.test.service;

import java.util.List;

import com.nag.test.dto.UserDataGroup;
import com.nag.test.dto.UserPaginationDetails;
import com.nag.test.pojo.User;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
public interface UserService {

	/**
	 * Gets the users by city.
	 *
	 * @param city the city
	 * @return the users by city
	 */
	public List<User> getUsersByCity(String city);
	
	/**
	 * Gets the user.
	 *
	 * @param userName the user name
	 * @return the user
	 * @throws Exception the exception
	 */
	public User getUser(String userName) throws Exception;
	
	/**
	 * Gets the user data by group.
	 *
	 * @return the user data by group
	 */
	public List<UserDataGroup> getUserDataByGroup(String city);  
	
	/**
	 * Gets the users count.
	 *
	 * @return the users count
	 */
	public Integer getUsersCount();
	
	/**
	 * Gets the users.
	 *
	 * @param pageSize the page size
	 * @param currentPage the current page
	 * @return the users
	 */
	public UserPaginationDetails getUsers(Integer pageSize,Integer currentPage);

}
