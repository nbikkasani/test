package com.nag.test.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@XmlRootElement(name="users")
public class UserPaginationDetails {

	/** The user data. */
	private List<UserData> userData;

	/** The total pages. */
	private Integer totalPages;
	
	/** The current page. */
	private Integer currentPage;
	
	/** The page size. */
	private Integer pageSize;

	/**
	 * Gets the user data.
	 *
	 * @return the user data
	 */
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

	/**
	 * Gets the total pages.
	 *
	 * @return the total pages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * Sets the total pages.
	 *
	 * @param totalPages the new total pages
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * Gets the current page.
	 *
	 * @return the current page
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * Sets the current page.
	 *
	 * @param currentPage the new current page
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


}
