package com.nag.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nag.test.common.util.MyException;
import com.nag.test.dao.UserDao;
import com.nag.test.dto.UserData;
import com.nag.test.dto.UserDataGroup;
import com.nag.test.dto.UserPaginationDetails;
import com.nag.test.pojo.User;
import com.nag.test.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	/** The user dao. */
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.nag.test.service.UserService#getUsersByCity(java.lang.String)
	 */
	@Override
	public List<User> getUsersByCity(String city) {
		return userDao.getUsersByCity(city);
	}

	/* (non-Javadoc)
	 * @see com.nag.test.service.UserService#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String userName) throws MyException {
		return userDao.getUser(userName);
	}

	/* (non-Javadoc)
	 * @see com.nag.test.service.UserService#getUsersCount()
	 */
	@Override
	public Integer getUsersCount() {
		return userDao.getUsersCount().intValue();
	}

	/* (non-Javadoc)
	 * @see com.nag.test.service.UserService#getUsers(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public UserPaginationDetails getUsers(Integer pageSize, Integer currentPage) {
		
		UserPaginationDetails userPaginationDetails = new UserPaginationDetails();
		
		Integer usersCount = getUsersCount();
		
		Integer totalPages = (int) Math.ceil(usersCount / pageSize);
		
		if (usersCount % pageSize > 0) 
			totalPages = totalPages+1;
		
		if(currentPage>totalPages||currentPage<1)
			currentPage= 1;
		
		//calculate the first result 
		int first  = currentPage * pageSize -pageSize;    
		
		// the number of items on the page might be less than the page size
		int count = Math.min(pageSize, usersCount - first);        
		
		List<UserData> usersData = new ArrayList<UserData>();
		
		List<User> users = userDao.getUsers(first, count);
		for (User user : users) {
			UserData userData = new UserData();
			userData.setFirstName(user.getFirstName());
			userData.setLastName(user.getLastName());
			userData.setCity(user.getCity());
			userData.setState(user.getState());
			usersData.add(userData);
		}
		userPaginationDetails.setUserData(usersData);
		userPaginationDetails.setPageSize(pageSize);
		userPaginationDetails.setTotalPages(totalPages);
		userPaginationDetails.setCurrentPage(currentPage);
		return userPaginationDetails;
	}

	/* (non-Javadoc)
	 * @see com.nag.test.service.UserService#getUserDataByGroup(java.lang.String)
	 */
	@Override
	public List<UserDataGroup> getUserDataByGroup(String city) {
		return userDao.getUserDataByGroup(city);
	}


}
