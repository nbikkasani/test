package com.nag.test.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@Entity
@Table(name = "User")
public class User {

	/** The user id. */
	private Integer userId;
	
	/** The user name. */
	private String userName;
	
	/** The password. */
	private String password;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;
	
	/** The gender. */
	private String gender;

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	@Id
	@Column
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	@Column
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Column
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@Column
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	@Column
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	@Column
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	@Column
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	@Column
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "USER [FirstName=" + firstName + ", LastName=" + lastName
				+ ", City=" + city + "]";
	}
}
