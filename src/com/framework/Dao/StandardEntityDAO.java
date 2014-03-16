package com.framework.Dao;

import org.hibernate.Session;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

public abstract class StandardEntityDAO<T> {
	public StandardEntityDAO() {

	}

	public StandardEntityDAO(Session p_session) {
		_session = p_session;
	}

	private Session _session = null;

	public Session getSession() {
		if (_session == null) {
			_session = SessionFactoryProvider.getSession();
		}
		return _session;

	}

	private Class<T> _entityClass = null;

	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		if (_entityClass == null) {
			_entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return _entityClass;
	}

	public String getEntityName() {
		Class<T> cls = getEntityClass();
		Entity entityAnnotation = cls.getAnnotation(Entity.class);
		return entityAnnotation.name();
	}

	public void close() {

		if (_currenTransaction != null) {
			_currenTransaction.commit();
			_currenTransaction = null;
		}
		if (_session != null)
			_session.close();
	}

	private Transaction _currenTransaction = null;

	public Transaction beginTransaction() {

		Session session = getSession();
		_currenTransaction = session.beginTransaction();
		return _currenTransaction;
	}

	public void commitTransaction() {
		if (_currenTransaction != null) {
			_currenTransaction.commit();
			_currenTransaction = null;
		}
	}

	public void rollbackTransaction() {
		if (_currenTransaction != null) {
			_currenTransaction.rollback();
			_currenTransaction = null;
		}
	}

	@SuppressWarnings("unchecked")
	public T selectById(int p_id) {
		Session session = getSession();
		T po = (T) session.get(getEntityClass(), p_id);
		return po;
	}

	@SuppressWarnings("unchecked")
	public List<T> select(String p_query) {
		Session session = getSession();
		Query query = session.createQuery(p_query);
		List<T> entities = query.list();
		return entities;
	}

	public Integer selectCount(String p_query) {
		Integer rowCount = 0;
		try {
			Session session = getSession();
			_currenTransaction = beginTransaction();
			rowCount = Integer.valueOf(session.createQuery(p_query)
					.uniqueResult().toString());
			_currenTransaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			_currenTransaction.rollback();
			e.printStackTrace();
		}
		return rowCount;

	}

	@SuppressWarnings("unchecked")
	public List<T> select(String _string, int pageIndex, int pageSize) {
		Session session = getSession();
		Query query = session.createQuery(_string);
		if (pageIndex > 0) {
			query.setFirstResult(pageIndex);
		}
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		List<T> entities = query.list();
		return entities;

	}

	@SuppressWarnings("unchecked")
	public List<T> select(DAOQuery p_query) {
		Session session = getSession();

		String queryString = " from " + getEntityName()
				+ p_query.getQueryString();
		Query query = session.createQuery(queryString);
		if (p_query.get_pageSize() > 0) {
			query.setMaxResults(p_query.get_pageSize());
		}
		if (p_query.get_pageIndex() >= 0) {
			query.setFirstResult(p_query.get_pageIndex()
					* p_query.get_pageSize());
		}
		if (p_query.getParameters() != null) {
			Map<String, Object> params = p_query.getParameters();
			Set<String> keys = params.keySet();
			for (String key : keys) {
				query.setParameter(key, p_query.getParameters(key));
			}
		}
		query.setCacheable(p_query.isCachable());
		if (p_query.isCachable()) {
			if (p_query.getCacheRegion() != null) {
				query.setCacheRegion(p_query.getCacheRegion());
			}
			query.setCacheMode(CacheMode.NORMAL);
		}

		List<T> entities = query.list();
		return entities;
	}

	public T selectFirst(DAOQuery p_query) {
		p_query.set_pageIndex(0);
		p_query.set_pageSize(1);
		List<T> entities = select(p_query);
		return entities.size() > 0 ? entities.get(0) : null;
	}

	public List<T> selectAll(String p_orderByClause) {
		DAOQuery query = new DAOQuery(getEntityName());
		query.set_whereClause(p_orderByClause);
		List<T> entities = select(query);
		return entities;
	}

	public List<T> selectAll() {
		return selectAll("");
	}

	public void save(T p_entity) {

		try {
			Session session = getSession();
			_currenTransaction = beginTransaction();
			session.save(p_entity);
			_currenTransaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			_currenTransaction.rollback();
			e.printStackTrace();
		}
	}

	public void saveAll(List<T> p_entityList) {
		for (T entity : p_entityList) {
			save(entity);
		}
	}

	public void update(T p_entity) {

		try {
			Session session = getSession();
			// Session session = getSession();
			_currenTransaction = beginTransaction();
			// session.save(p_entity);
			session.update(p_entity);
			System.out.println("1234");
			_currenTransaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			_currenTransaction.rollback();
			e.printStackTrace();
		}

	}

	public void updateAll(List<T> p_entityList) {
		for (T entity : p_entityList) {
			update(entity);
		}
	}

	public void delete(T p_entity) {
		try {
			Session session = getSession();

			_currenTransaction = beginTransaction();
			session.delete(p_entity);
			_currenTransaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			_currenTransaction.rollback();
			e.printStackTrace();
		}
	}

}
