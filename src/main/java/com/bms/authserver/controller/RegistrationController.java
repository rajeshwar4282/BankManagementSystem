package com.bms.authserver.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.authserver.pojo.RegistrationData;
import com.bms.authserver.pojo.ResponseData;
import com.bms.authserver.util.CommonUtils;

@RestController("/emp")
public class RegistrationController {
	
	
	@PostMapping("/register")
	public <ResponseEntity>ResponseData registerNewUser(@Valid RegistrationData registrationData, BindingResult bindingResult) {
		
		
		
		ResponseData response =  new ResponseData("username", "ststus", 200, "message");
		return response;
	}

}
