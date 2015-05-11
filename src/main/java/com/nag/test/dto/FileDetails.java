package com.nag.test.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class FileDetails.
 */
@XmlRootElement(name="files")
public class FileDetails {

	/** The file details. */
	private List<FileDetail> fileDetails;

	/**
	 * Gets the file details.
	 *
	 * @return the file details
	 */
	public List<FileDetail> getFileDetails() {
		return fileDetails;
	}

	/**
	 * Sets the file details.
	 *
	 * @param fileDetails the new file details
	 */
	public void setFileDetails(List<FileDetail> fileDetails) {
		this.fileDetails = fileDetails;
	}

}
