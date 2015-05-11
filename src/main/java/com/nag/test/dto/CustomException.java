package com.nag.test.dto;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@XmlRootElement(name="exception")
public class CustomException {

	/** The message. */
	private String message;
	
	/** The url requested. */
	private String urlRequested;

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Gets the url requested.
	 *
	 * @return the url requested
	 */
	public String getUrlRequested() {
		return urlRequested;
	}
	
	/**
	 * Sets the url requested.
	 *
	 * @param urlRequested the new url requested
	 */
	public void setUrlRequested(String urlRequested) {
		this.urlRequested = urlRequested;
	}

}
