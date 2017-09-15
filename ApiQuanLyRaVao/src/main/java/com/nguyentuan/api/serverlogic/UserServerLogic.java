package com.nguyentuan.api.serverlogic;

import java.util.List;

import com.nguyentuan.api.dto.GetUserDxoDto;
import com.nguyentuan.api.dto.GetUserNameRequestDto;
import com.nguyentuan.api.entity.UserEntity;
import com.nguyentuan.api.model.UserModel;

public interface UserServerLogic {
	
	UserEntity checkUser(GetUserNameRequestDto userlogindto);
	List<UserModel> getAllUser(GetUserNameRequestDto Userlogindto );
	boolean changePassword(GetUserDxoDto getUserDto);
	

}
