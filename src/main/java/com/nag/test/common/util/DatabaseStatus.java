package com.nag.test.common.util;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
public enum DatabaseStatus {
	
	/** The status active. */
	STATUS_ACTIVE("Active"), 
	
	/** The status inactive. */
	STATUS_INACTIVE("Inactive")
	;
	
 	/** The value. */
	 private String value;

	/**
	 * Instantiates a new database status.
	 *
	 * @param value the value
	 */
	DatabaseStatus(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getvalue() {
		return value;
	}
	
	/**
	 * The main method.
	 *
	 * @param arg the arguments
	 */
	static public void main(String arg[])
	{
		System.out.println(DatabaseStatus.STATUS_ACTIVE.getvalue());
	}

};