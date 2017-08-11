package com.nguyentuan.api.action;

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
import com.nguyentuan.api.dto.GetUserNameRequestDto;
import com.nguyentuan.api.model.UserModel;
import com.nguyentuan.api.serverlogic.UserServerLogic;
import com.nguyentuan.api.serverlogicImpl.*;

@RestController
public class UserAutoAction {
	@Autowired
	UserServerLogicImpl abc;

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String checklogin(@Validated GetUserNameRequestDto userdto , BindingResult result , HttpServletRequest httpRequest)
			throws JsonProcessingException {

		UserModel userModel = new UserModel();
		ObjectMapper obj = new ObjectMapper();
		;
		String abcd = httpRequest.getParameter("userNamedd");
System.out.println(abcd="aaaaaaaaaaaaaaaaaaa");
		try{
			
			if(result.hasErrors()){
				
				userModel.setStatus(FLConstant.status.ERROR);
				
			}else{
				
				userModel=abc.checkUser(userdto);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	
		
		return obj.writeValueAsString(userModel);
	}

}
