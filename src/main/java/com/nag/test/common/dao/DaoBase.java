package com.nag.test.common.dao;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 *
 * @param <K> the key type
 * @param <T> the generic type
 */
public interface DaoBase<K extends Serializable, T> {

	/**
	 * Gets the.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T get(K id);
	
	/**
	 * Save.
	 *
	 * @param record the record
	 * @return the t
	 */
	public T save(T record);

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<T> getAll();


}
