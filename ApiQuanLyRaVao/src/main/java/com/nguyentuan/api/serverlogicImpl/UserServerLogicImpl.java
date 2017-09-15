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

import com.nguyentuan.api.dto.GetUserDxoDto;
import com.nguyentuan.api.dto.GetUserNameRequestDto;
import com.nguyentuan.api.entity.UserEntity;
import com.nguyentuan.api.logic.UserLogic;
import com.nguyentuan.api.logicImpl.UserLogicImpl;
import com.nguyentuan.api.model.UserModel;
import com.nguyentuan.api.util.HibernateUtil;

@Service
public  class UserServerLogicImpl implements UserLogic {
	@Autowired
	private UserLogicImpl userLogicImpl;
	@Transactional()
	public UserEntity checkUser(GetUserNameRequestDto userlogindto) {
		return userLogicImpl.checkUser(userlogindto);
	}

	@Override
	public List<UserModel> getAllUser(GetUserNameRequestDto Userlogindto) {
		// TODO Auto-generated method stub
		return userLogicImpl.getAllUser(Userlogindto);
	}
	@Override
	public boolean changePassword(GetUserDxoDto getUserDto) {
		
		
		return userLogicImpl.changePassword(getUserDto);
	}

}
