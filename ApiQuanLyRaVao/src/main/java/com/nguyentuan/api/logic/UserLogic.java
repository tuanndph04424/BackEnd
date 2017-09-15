package com.nguyentuan.api.logic;

import java.util.List;

import com.nguyentuan.api.dto.GetUserDto;
import com.nguyentuan.api.dto.GetUserDxoDto;
import com.nguyentuan.api.dto.GetUserNameRequestDto;
import com.nguyentuan.api.entity.UserEntity;
import com.nguyentuan.api.model.UserModel;

public interface UserLogic {
	
	UserEntity checkUser(GetUserNameRequestDto Userlogindto );
	List<UserModel> getAllUser(GetUserNameRequestDto Userlogindto );
	boolean changePassword(GetUserDxoDto getUserDto);
	

}
