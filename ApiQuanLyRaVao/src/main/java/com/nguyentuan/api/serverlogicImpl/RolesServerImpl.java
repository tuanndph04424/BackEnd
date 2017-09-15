package com.nguyentuan.api.serverlogicImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentuan.api.data.AbstractDaoImpl;
import com.nguyentuan.api.entity.RolesEntity;
import com.nguyentuan.api.logic.RolesDao;
import com.nguyentuan.api.logicImpl.RolesDaoImpl;
import com.nguyentuan.api.serverlogic.RolesServer;
import com.nguyentuan.api.util.HibernateUtil;

@Service
@Transactional
public class RolesServerImpl extends AbstractDaoImpl<Integer, RolesEntity> implements RolesServer {

	@Autowired
	RolesDao  rolesDao ;
	
	@Override
	public List<RolesEntity> findAll() {
		// TODO Auto-generated method stub
		return rolesDao.findAll();
	}
	
	
	

}
