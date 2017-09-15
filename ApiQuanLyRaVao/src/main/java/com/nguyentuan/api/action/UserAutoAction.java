package com.nguyentuan.api.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyentuan.api.common.FLConstant;
import com.nguyentuan.api.dto.GetUserDto;
import com.nguyentuan.api.dto.GetUserDxoDto;
import com.nguyentuan.api.dto.GetUserNameRequestDto;
import com.nguyentuan.api.entity.RolesEntity;
import com.nguyentuan.api.entity.UserEntity;
import com.nguyentuan.api.model.UserModel;
import com.nguyentuan.api.model.status;
import com.nguyentuan.api.serverlogic.RolesServer;
import com.nguyentuan.api.serverlogic.UserServerLogic;
import com.nguyentuan.api.serverlogicImpl.*;
import com.nguyentuan.api.util.FLBeanUtil;

@RestController
public class UserAutoAction {
	@Autowired
	UserServerLogicImpl userServerLogiImpl;
	@Autowired
	RolesServer rolesServerImpl;

	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String insert (RolesEntity userdto )
			throws JsonProcessingException {
		
		
	

		rolesServerImpl.save(userdto);
		
		return "thanhcong";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String checklogin(@Validated GetUserNameRequestDto userdto , BindingResult result )
			throws JsonProcessingException {

		UserModel userModel = new UserModel();
		UserEntity employees =userServerLogiImpl.checkUser(userdto);
		ObjectMapper obj = new ObjectMapper();
		;
		try{
			
			if(result.hasErrors()){				
				userModel.setStatus(FLConstant.MES_VALIDATION_ERROR);				
			}else{										
				if (employees != null) {

					try {
						FLBeanUtil.copyPropertiesNative(employees, userModel);
						System.out.println(userModel.getCreate());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

					userModel.setStatus(FLConstant.status.ERROR);
				}									
								
			}			
		}
		catch(Exception e){
			e.printStackTrace();			
		}		
		return obj.writeValueAsString(userModel);
	}
	
	@RequestMapping(value = "/getAllUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getAllUser(@Validated GetUserNameRequestDto userdto , BindingResult result )
			throws JsonProcessingException {

		List<UserModel> userModel = new ArrayList<UserModel>();
		
		ObjectMapper obj = new ObjectMapper();
		Object object = new Object();
		
		
		int a =userdto.getID();
		System.out.println( a + 2);
		try{
			
			if(result.hasErrors()){				
				status model = new status();
				model.setStatus(FLConstant.status.ERROR);
				object = model;
				obj.writeValueAsString(model);
				
			}else{										
			
				userModel=userServerLogiImpl.getAllUser(userdto);
				object=userModel;
						
								
			}			
		}
		catch(Exception e){
			e.printStackTrace();			
		}		
		return obj.writeValueAsString(object);
	}
	
	
	
	
	@RequestMapping(value ="/changPassword",method=RequestMethod.POST ,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String changPassword(@Validated GetUserDto getUserDto , BindingResult result) throws Exception{
		status  status = new status();
		GetUserDxoDto getUserDxoDto = new GetUserDxoDto();
		ObjectMapper obj = new ObjectMapper();
		if(result.hasErrors()){
			status.setStatus(FLConstant.MES_VALIDATION_ERROR);			
		}else{
			getUserDxoDto=(GetUserDxoDto)FLBeanUtil.createAndCopyPropertiesNative(getUserDto, GetUserDxoDto.class);
			userServerLogiImpl.changePassword(getUserDxoDto);
			status.setStatus(FLConstant.status.STATUS);			
			
		}
		
	return  obj.writeValueAsString(status);
	}
	

}
