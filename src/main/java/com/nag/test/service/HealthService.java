package com.nag.test.service;

import com.nag.test.dto.Database;
import com.nag.test.dto.Memory;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
public interface HealthService {
	
	/** The Constant SUCCESS_MESSAGE. */
	public static final String SUCCESS_MESSAGE="Doing Great!";

	/**
	 * Gets the memory stats.
	 *
	 * @return the memory stats
	 */
	public Memory getMemoryStats();
	
	/**
	 * Gets the database stats.
	 *
	 * @param url the url
	 * @return the database stats
	 */
	public Database getDatabaseStats(String url);
}
