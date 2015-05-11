package com.nag.test.dto;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@XmlRootElement(name="metrics")
public class Health {

	/** The memory. */
	private Memory memory;
	
	/** The database. */
	private Database database;
	

	/**
	 * Gets the memory.
	 *
	 * @return the memory
	 */
	public Memory getMemory() {
		return memory;
	}

	/**
	 * Sets the memory.
	 *
	 * @param memory the new memory
	 */
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	
	/**
	 * Gets the database.
	 *
	 * @return the database
	 */
	public Database getDatabase() {
		return database;
	}

	/**
	 * Sets the database.
	 *
	 * @param database the new database
	 */
	public void setDatabase(Database database) {
		this.database = database;
	}

}
