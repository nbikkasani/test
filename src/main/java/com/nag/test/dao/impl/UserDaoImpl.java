package com.nag.test.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.nag.test.common.dao.impl.DaoBaseImpl;
import com.nag.test.dao.UserDao;
import com.nag.test.dto.UserDataGroup;
import com.nag.test.pojo.User;

// TODO: Auto-generated Javadoc
/**
 * * @author nag.
 */
@Repository("userDao")
public class UserDaoImpl extends DaoBaseImpl<Integer, User> implements UserDao {

	/* (non-Javadoc)
	 * @see com.nag.test.dao.UserDao#getUsersByCity(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByCity(final String city) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("city", city).ignoreCase())
				     .addOrder(Order.asc("gender"));
		return c.list();
	}

	/* (non-Javadoc)
	 * @see com.nag.test.dao.UserDao#getUser(java.lang.String)
	 */
	@Override
	public User getUser(final String userName) {
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("userName", userName)).uniqueResult();
		return user;
	}

	/* (non-Javadoc)
	 * @see com.nag.test.dao.UserDao#getUsersCount()
	 */
	@Override
	public Long getUsersCount() {
		Long count = (Long) sessionFactory.getCurrentSession()    
				.createCriteria(User.class)
				.setProjection(Projections.rowCount())
				.list().get(0);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.nag.test.dao.UserDao#getUsers(java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers(final Integer startResult, final Integer maxResult) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class)
					.setFirstResult(startResult)
					.setMaxResults(maxResult)
					.addOrder(Order.desc("city"));
		return c.list();
	}
	
	/* (non-Javadoc)
	 * @see com.nag.test.dao.UserDao#getUserDataByGroup(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<UserDataGroup> getUserDataByGroup(final String city)  {
		Criteria c = sessionFactory
				.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("city", city).ignoreCase())
				.setProjection(
						Projections.projectionList().add(Projections.groupProperty("gender"), "gender")
													.add(Projections.rowCount(), "count"))		
				.setResultTransformer(Transformers.aliasToBean(UserDataGroup.class));
		return c.list();
	}

}
