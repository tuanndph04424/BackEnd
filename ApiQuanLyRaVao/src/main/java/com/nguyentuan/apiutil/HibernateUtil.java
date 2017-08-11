package com.nguyentuan.apiutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtil {

	 private static final SessionFactory sessionFactory;
	    
	    static {
	        try {
	            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
//	    
	    public static void main(String args[]){
	    	  System.out.println("::::::::dfd:::::")
;	    	HibernateUtil hibernateUtil = new HibernateUtil();	    	
	    System.out.println("aaa"+hibernateUtil.getSessionFactory());	
	    	
	    }
}
