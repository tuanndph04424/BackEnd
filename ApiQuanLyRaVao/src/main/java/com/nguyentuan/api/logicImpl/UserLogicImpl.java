package com.nguyentuan.api.logicImpl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import com.nguyentuan.api.common.FLConstant;
import com.nguyentuan.api.dto.GetUserDto;
import com.nguyentuan.api.dto.GetUserDxoDto;
import com.nguyentuan.api.dto.GetUserNameRequestDto;
import com.nguyentuan.api.entity.DepartmentEntity;
import com.nguyentuan.api.entity.UserEntity;
import com.nguyentuan.api.logic.UserLogic;
import com.nguyentuan.api.model.DepertmentModel;
import com.nguyentuan.api.model.UserModel;
import com.nguyentuan.api.util.FLBeanUtil;
import com.nguyentuan.api.util.HibernateUtil;

@Repository
public class UserLogicImpl implements UserLogic {

	public UserEntity checkUser(GetUserNameRequestDto userlogindto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ").append(" FROM user").append(" Where UserName = :username ")
					.append(" AND Password = :password  ").append("AND IsLock = 0 ");

			SQLQuery query = session.createSQLQuery(sql.toString()).addEntity(UserEntity.class);
			query.setParameter("username", userlogindto.getUserName());
			query.setParameter("password", userlogindto.getPassWord());
			UserEntity employees = (UserEntity) query.uniqueResult();

			System.out.println(employees.getDepartmentID().getName() + "aaaaaaaaaa");
			transaction.commit();

			return employees;
		} catch (RuntimeException var4) {

			throw var4;
		} finally {
			session.flush();
			session.close();
		}

	}

	public List<UserModel> checkUser2(String username, String pass) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(
					"SELECT `ID`, `UserName`, `Password`, `Status`, `Actived`, `IsLock`, `Name`, `FullName` FROM `user` WHERE UserName ='"
							+ username + "' AND Password= '" + pass + "' AND IsLock = 0 ");

			List<Object[]> rows = query.list();
			List<UserModel> billingModel = new ArrayList<UserModel>();
			for (Object[] row : rows) {
				UserModel emp = new UserModel();
				emp.setFullName(row[7].toString());
				emp.setID(Integer.parseInt(row[0].toString()));
				emp.setActived(Boolean.parseBoolean(row[4].toString()));
				emp.setName(row[6].toString());

				emp.setUserName(row[1].toString());
				billingModel.add(emp);

			}

			transaction.commit();

			for (UserModel model : billingModel) {
				System.out.println(model.getID() + model.getFullName() + model.getPassword());

			}

			
			
			
			return billingModel;
		} catch (RuntimeException var4) {
			throw var4;
		
		} finally {
			session.flush();
			session.close();
		}

	}

	public List<UserModel> getAllUser(GetUserNameRequestDto userlogindto) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String sql = "SELECT *FROM user INNER JOIN department ON user.DepartmentID = department.ID where user.UserName='"
					+ userlogindto.getUserName() + "' AND Password='" + userlogindto.getPassWord() + "' ";
			SQLQuery query = session.createSQLQuery(sql).addEntity(UserEntity.class).addEntity(DepartmentEntity.class);

			List<Object[]> objs = (List<Object[]>) query.list();
			UserEntity userEntity = new UserEntity();
			UserModel userModel = new UserModel();
			DepertmentModel depertmentModel = new DepertmentModel();
			DepartmentEntity departmentEntity = new DepartmentEntity();

			List<UserModel> listUserModel = new ArrayList<UserModel>();

			
				for (Object[] row : objs) {
					userEntity = (UserEntity) row[0];
					departmentEntity = (DepartmentEntity) row[1];

					try {
						FLBeanUtil.copyPropertiesNative(userEntity, userModel);
						FLBeanUtil.copyPropertiesNative(departmentEntity, depertmentModel);
						userModel.setDepertment(depertmentModel);

						listUserModel.add(userModel);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				
				
			}
			
			

			transaction.commit();

			return listUserModel;
		} catch (RuntimeException var4) {
			throw var4;
		} finally {
			session.flush();
			session.close();
		}

	}
	public static void main(String args[]) {
		UserLogicImpl impl = new UserLogicImpl();
		GetUserNameRequestDto userlogindto = new GetUserNameRequestDto();
		userlogindto.setPassWord("abc");
		userlogindto.setUserName("4424");
		
		List<UserModel> list = new ArrayList<>();
		list=impl.getAllUser(userlogindto);
		for( UserModel model  :list ){
			System.out.println(model.getFullName()+"aaaaaaaaaaaaaa");
			
		}

	}
	

	@Override
	public boolean changePassword(GetUserDxoDto getUserDto) {
		boolean kq = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ").append(" FROM user").append(" Where UserName = :username ")
					.append(" AND Password = :password  ").append("AND IsLock = 0 ");

			SQLQuery query = session.createSQLQuery(sql.toString()).addEntity(UserEntity.class);
			query.setParameter("username", getUserDto.getUserName());
			query.setParameter("password", getUserDto.getPassword());
			UserEntity employees = (UserEntity) query.uniqueResult();

			if (employees != null) {
				StringBuffer stringBuffer = new StringBuffer();
				stringBuffer.append(" UPDATE user SET ").append(" Password =[ :password ] ").append(" Where ID = : id ")
						.append(" AND  UserName = :username ");

				SQLQuery updateChangPassword = session.createSQLQuery(sql.toString());
				updateChangPassword.setParameter("password", getUserDto.getNew_Password());
				updateChangPassword.setParameter("id", getUserDto.getID());
				updateChangPassword.setParameter("username", getUserDto.getUserName());
				updateChangPassword.executeUpdate();
				kq = true;
			}

			transaction.commit();

			return kq;
		} catch (RuntimeException var4) {

			throw var4;
		} finally {
			session.flush();
			session.close();
		}

	}

}
