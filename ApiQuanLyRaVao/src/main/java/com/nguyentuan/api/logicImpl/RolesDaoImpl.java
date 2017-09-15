package com.nguyentuan.api.logicImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.nguyentuan.api.data.AbstractDaoImpl;
import com.nguyentuan.api.entity.RolesEntity;
import com.nguyentuan.api.logic.RolesDao;
import com.nguyentuan.api.util.HibernateUtil;




@Repository

public class RolesDaoImpl extends AbstractDaoImpl<Integer, RolesEntity> implements RolesDao {

	@Override
	public List<RolesEntity> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<RolesEntity> employees;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from RolesEntity");
			employees = query.list();
			transaction.commit();

		} catch (RuntimeException var4) {
			throw var4;
		} finally {
			session.flush();
			session.close();
		}
		return employees;
		
	}
	
	
	
	
	
}
