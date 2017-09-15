package com.nguyentuan.api.data;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.nguyentuan.api.util.HibernateUtil;





public abstract class AbstractDaoImpl<ID extends Serializable, T> implements GenericDao<ID, T> {

	private final Class<T> persistentClass;

	public AbstractDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public AbstractDaoImpl(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T save(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			session.persist(entity);

			System.out.println("" + entity);
			transaction.commit();
			return entity;
		
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.flush();
			session.close();
		}
	}

	// @Override
	// public List<T> findAll(String sql) {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// Transaction transaction = null;
	// try {
	// transaction = session.beginTransaction();
	//
	// SQLQuery query = session.createSQLQuery(sql);
	// query.addEntity(this.persistentClass);
	// List<T> employees = query.list();
	// transaction.commit();
	//
	// return employees;
	// } catch (RuntimeException var4) {
	// throw var4;
	// } finally {
	// session.flush();
	// session.close();
	// }
	// }

	@Override
	public T update(T var1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(var1);
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return var1;

	}

	@Override
	public T findById(ID var1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			T employees = (T) session.get(this.persistentClass, var1);
			transaction.commit();
			return employees;

		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public Integer listDelete(List<ID> var1) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		Integer response = 0;
		try {
			for (ID item : var1) {
				T t = (T) session.get(this.persistentClass, item);
				session.delete(t);
				response++;
			}
		} catch (RuntimeException e) {
			throw e;
		}
		return response;
	}

	@Override
	public Integer delete(ID var1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			T t = (T) session.get(this.persistentClass, var1);
			session.delete(t);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

}
