package com.nguyentuan.api.dto;

import com.nguyentuan.api.beans.ParamName;
import com.nguyentuan.api.validation.LengthMax;
import com.nguyentuan.api.validation.RequiredNotBlank;

public class GetUserNameRequestDto {
	@RequiredNotBlank
	@LengthMax(max = 15)
	@ParamName("userNamedd")
	private String UserName;
	@RequiredNotBlank
	@LengthMax(max = 15)
	@ParamName("passworddd")
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

	
	
	
}
