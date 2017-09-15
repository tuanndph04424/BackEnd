package com.nguyentuan.api.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nguyentuan.api.entity.DepartmentEntity;
import com.nguyentuan.api.util.HibernateUtil;

public class tesst {
	public DepartmentEntity save(DepartmentEntity entity) {
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
	
	
	
	
	public Integer delete(int  var1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			DepartmentEntity t = new DepartmentEntity();
			t.setID(var1);
			
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
	
	
	
	
	
	
	
	
	
	
	public  static void main(String args[]){
		
		tesst tesst1 = new tesst();
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setDescriptions("aaaaaaaa");
		departmentEntity.setName("nguyen dang tuan");
		departmentEntity.setStatus(true);
		tesst1.save(departmentEntity);
		
	}

}
