package com.nag.test.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nag.test.common.dao.DaoBase;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 *
 * @param <K> the key type
 * @param <T> the generic type
 */
public class DaoBaseImpl<K extends Serializable, T> implements DaoBase<K, T> {

	/** The entity class. */
	protected Class<T> entityClass;

	/** The session factory. */
	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * Instantiates a new dao base impl.
	 */
	@SuppressWarnings("unchecked")
	public DaoBaseImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[1];
	}

	/* (non-Javadoc)
	 * @see com.nag.test.common.dao.DaoBase#get(java.io.Serializable)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T get(K id) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see com.nag.test.common.dao.DaoBase#save(java.lang.Object)
	 */
	@Override
	public T save(T record) {
		sessionFactory.getCurrentSession().save(record);
		return record;
	}

	/**
	 * Save or update.
	 *
	 * @param record the record
	 */
	public void saveOrUpdate(T record) {
		sessionFactory.getCurrentSession().saveOrUpdate(record);
	}

	/* (non-Javadoc)
	 * @see com.nag.test.common.dao.DaoBase#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(entityClass)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

}
