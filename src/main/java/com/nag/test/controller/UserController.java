package com.nag.test.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nag.test.common.util.MyException;
import com.nag.test.dto.CustomException;
import com.nag.test.dto.UserData;
import com.nag.test.dto.UserDataGroup;
import com.nag.test.dto.UserDetails;
import com.nag.test.dto.UserLogin;
import com.nag.test.dto.UserPaginationDetails;
import com.nag.test.pojo.User;
import com.nag.test.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@Controller
@RequestMapping("users")
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The Constant logger. */
	private final static Logger logger = LoggerFactory
			.getLogger(UserController.class);

	/**
	 * Validate user.
	 * 
	 * @param userLogin
	 *            the user login
	 * @return the model and view
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public ModelAndView validateUser(@RequestBody UserLogin userLogin)
			throws Exception {
		ModelAndView model = new ModelAndView();

		if (StringUtils.isEmpty(userLogin.getUsername())
				|| StringUtils.isEmpty(userLogin.getPassword()))
			throw new MyException("UserName/Password can't be empty!");

		User user = userService.getUser(userLogin.getUsername().trim());

		if (null == user)
			throw new MyException("User Not Found!");

		if (!hashPassword(userLogin.getPassword().trim()).equals(
				user.getPassword().trim()))
			throw new MyException("InCorrect Password!");

		UserData userData = new UserData();
		userData.setFirstName(user.getFirstName());
		userData.setLastName(user.getLastName());
		userData.setCity(user.getCity());
		userData.setState(user.getState());

		model.addObject("userData", userData);
		model.setViewName("userData");

		return model;
	}

	/**
	 * List users.
	 * 
	 * @param city
	 *            the city
	 * @return the model and view
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/{city}", method = RequestMethod.GET)
	public ModelAndView listUsers(@PathVariable(value = "city") String city)
			throws Exception {
		ModelAndView model = new ModelAndView();

		if (city == null)
			throw new MyException("City Not Found!");

		List<User> users = userService.getUsersByCity(city);

		UserDetails userDetails = new UserDetails();
		List<UserData> usersData = new ArrayList<UserData>();

		for (User user : users) {
			UserData userData = new UserData();
			userData.setFirstName(user.getFirstName());
			userData.setLastName(user.getLastName());
			userData.setCity(user.getCity());
			userData.setState(user.getState());
			usersData.add(userData);
		}
		userDetails.setUserData(usersData);
		model.addObject("usersList", userDetails);
		model.setViewName("userDetails");
		return model;
	}

	/**
	 * List users.
	 * 
	 * @param pagesize
	 *            the pagesize
	 * @param currentpage
	 *            the currentpage
	 * @return the model and view
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/{pagesize}/{currentpage}", method = RequestMethod.GET)
	public ModelAndView listUsers(
			@PathVariable(value = "pagesize") Integer pagesize,
			@PathVariable(value = "currentpage") Integer currentpage)
			throws Exception {
		ModelAndView model = new ModelAndView();

		UserPaginationDetails userPaginationDetails = userService.getUsers(
				pagesize, currentpage);

		model.addObject("usersList", userPaginationDetails);
		model.setViewName("userDetails");
		return model;
	}

	/**
	 * List users by group.
	 * 
	 * @param city
	 *            the city
	 * @return the model and view
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/group/{city}", method = RequestMethod.GET)
	public ModelAndView listUsersByGroup(
			@PathVariable(value = "city") String city) throws Exception {
		ModelAndView model = new ModelAndView();

		List<UserDataGroup> usersDataGroups = userService
				.getUserDataByGroup(city);

		model.addObject("usersDataGroups", usersDataGroups);
		model.setViewName("usersDataGroup");
		return model;
	}

	/**
	 * Handle exception.
	 * 
	 * @param req
	 *            the req
	 * @param exception
	 *            the exception
	 * @return the model and view
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req,
			Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		ModelAndView model = new ModelAndView();
		CustomException customException = new CustomException();
		customException.setMessage(exception.getMessage());
		customException.setUrlRequested(req.getRequestURL().toString());
		model.addObject("exceptions", customException);
		model.setViewName("error");
		return model;
	}

	/**
	 * Encrypts the password--MD5.
	 * 
	 * @param password
	 *            the password
	 * @return the string
	 */
	private String hashPassword(String password) {
		String hashword = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			BigInteger hash = new BigInteger(1, md5.digest());
			hashword = hash.toString(16);

		} catch (NoSuchAlgorithmException nsae) {

		}
		return pad(hashword, 32, '0');
	}

	/**
	 * Pad.
	 * 
	 * @param s
	 *            the s
	 * @param length
	 *            the length
	 * @param pad
	 *            the pad
	 * @return the string
	 */
	private String pad(String s, int length, char pad) {
		StringBuffer buffer = new StringBuffer(s);
		while (buffer.length() < length) {
			buffer.insert(0, pad);
		}
		return buffer.toString();
	}

}
