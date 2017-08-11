package com.nguyentuan.api.serverlogicImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyentuan.api.dto.GetUserNameRequestDto;
import com.nguyentuan.api.entity.UserEntity;
import com.nguyentuan.api.logic.UserLogic;
import com.nguyentuan.api.logicImpl.UserLogicImpl;
import com.nguyentuan.api.model.UserModel;
import com.nguyentuan.apiutil.HibernateUtil;

@Service
public class UserServerLogicImpl implements UserLogic {
	@Autowired
	private UserLogicImpl userLogicImpl;
	@Transactional()
	public UserModel checkUser(GetUserNameRequestDto userlogindto) {
		return userLogicImpl.checkUser(userlogindto);
	}

}
