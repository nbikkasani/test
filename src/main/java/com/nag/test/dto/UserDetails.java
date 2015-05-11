package com.nag.test.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@XmlRootElement(name="users")
public class UserDetails {
	
	/** The user data. */
	private List<UserData> userData;

	
    /**
     * Gets the user data.
     *
     * @return the user data
     */
    @XmlElement(name = "user")
	public List<UserData> getUserData() {
		return userData;
	}

	/**
	 * Sets the user data.
	 *
	 * @param userData the new user data
	 */
	public void setUserData(List<UserData> userData) {
		this.userData = userData;
	}
	
	/** The xmlns_xsd. */
	@XmlAttribute(name="xmlns:xsd")
	protected final String xmlns_xsd="http://www.w3.org/2001/XMLSchema"; 

	/** The xmlns_xsi. */
	@XmlAttribute(name="xmlns:xsi")
	protected final String xmlns_xsi="http://www.w3.org/2001/XMLSchema-instance"; 
}
