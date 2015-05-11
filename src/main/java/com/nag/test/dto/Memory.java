package com.nag.test.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Memory {

	/** The max memory. */
	private long maxMemory;
    
    /** The allocated memory. */
    private long allocatedMemory;
    
    /** The free memory. */
    private long freeMemory;

	/**
	 * Gets the max memory.
	 *
	 * @return the max memory
	 */
	public long getMaxMemory() {
		return maxMemory;
	}
	
	/**
	 * Sets the max memory.
	 *
	 * @param maxMemory the new max memory
	 */
	public void setMaxMemory(long maxMemory) {
		this.maxMemory = maxMemory;
	}
	
	/**
	 * Gets the allocated memory.
	 *
	 * @return the allocated memory
	 */
	public long getAllocatedMemory() {
		return allocatedMemory;
	}
	
	/**
	 * Sets the allocated memory.
	 *
	 * @param allocatedMemory the new allocated memory
	 */
	public void setAllocatedMemory(long allocatedMemory) {
		this.allocatedMemory = allocatedMemory;
	}
	
	/**
	 * Gets the free memory.
	 *
	 * @return the free memory
	 */
	public long getFreeMemory() {
		return freeMemory;
	}
	
	/**
	 * Sets the free memory.
	 *
	 * @param freeMemory the new free memory
	 */
	public void setFreeMemory(long freeMemory) {
		this.freeMemory = freeMemory;
	}

}
