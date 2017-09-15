package com.nguyentuan.api.dto;


import com.nguyentuan.api.validation.LengthMax;
import com.nguyentuan.api.validation.RequiredNotBlank;

public class GetUserNameRequestDto {
	private int ID;
	
	@RequiredNotBlank
	@LengthMax(max = 15)

	private String UserName;
	@RequiredNotBlank
	@LengthMax(max = 15)

	private String PassWord;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	
	
	
}
