package com.nguyentuan.api.dto;

import com.nguyentuan.api.model.status;

public class GetUserDto {
	private String ID;
	private String UserName;
	private String Password;
	private String New_Password;
	
	public GetUserDto() {
		super();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNew_Password() {
		return New_Password;
	}

	public void setNew_Password(String new_Password) {
		New_Password = new_Password;
	}

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	

}
