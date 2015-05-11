package com.nag.test.dto;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@XmlRootElement
public class UserDataGroup {

      /** The gender. */
      private String gender;  
	  
  	/** The count. */
  	private Long count;

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
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
	
	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}
	
	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(Long count) {
		this.count = count;
	}

}
