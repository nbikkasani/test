package com.nag.test.dao;

import java.util.List;

import com.nag.test.common.dao.DaoBase;
import com.nag.test.dto.UserDataGroup;
import com.nag.test.pojo.User;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
public interface UserDao extends DaoBase<Integer, User> {
	
	
	/**
	 * Gets the users by city.
	 *
	 * @param city the city
	 * @return the users by city
	 */
	public List<User> getUsersByCity(final String city);
	
	/**
	 * Gets the user.
	 *
	 * @param userName the user name
	 * @return the user
	 */
	public User getUser(final String userName);
	
	/**
	 * Gets the user data by group.
	 *
	 * @return the user data by group
	 */
	public List<UserDataGroup> getUserDataByGroup(final String city);  
	
	/**
	 * Gets the users count.
	 *
	 * @return the users count
	 */
	public Long getUsersCount();
	
	/**
	 * Gets the users.
	 *
	 * @param startResult the start result
	 * @param maxResult the max result
	 * @return the users
	 */
	public List<User> getUsers(final Integer startResult,final Integer maxResult);

}
