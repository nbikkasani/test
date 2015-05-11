package com.nag.test.service;

import com.nag.test.dto.FileDetails;


// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
public interface DirectoryListingService {

	/**
	 * Gets the files in directory.
	 *
	 * @param path the path
	 * @return the files in directory
	 */
	FileDetails getFilesInDirectory(String path);
	
	/**
	 * Gets the file details in directory.
	 *
	 * @param path the path
	 * @return the file details in directory
	 */
	FileDetails getFileDetailsInDirectory(String path);
}
