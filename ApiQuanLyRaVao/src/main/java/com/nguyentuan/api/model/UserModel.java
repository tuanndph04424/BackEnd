package com.nguyentuan.api.model;

import java.io.Serializable;
import java.sql.Timestamp;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel extends status implements  Serializable {
	
	private int ID;
	private String UserName;
	private String Password;
	private String Name;	
	private String FullName;
	private Timestamp Create;
	private boolean IsLock;
	private boolean Actived;

	

	public Timestamp getCreate() {
		return Create;
	}

	public void setCreate(Timestamp create) {
		Create = create;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public boolean isIsLock() {
		return IsLock;
	}

	public void setIsLock(boolean isLock) {
		IsLock = isLock;
	}

	public boolean isActived() {
		return Actived;
	}

	public void setActived(boolean actived) {
		Actived = actived;
	}

	

	public UserModel() {
		super();
	}
	
	public static void main(String args[]){
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        System.out.println(timestamp);
		
	
	}

}
