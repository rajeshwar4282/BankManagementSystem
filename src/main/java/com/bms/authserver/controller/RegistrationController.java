package com.bms.authserver.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.authserver.models.AccountDetail;
import com.bms.authserver.models.CustomerAddress;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.models.CustomerDetail;
import com.bms.authserver.pojo.RegistrationData;
import com.bms.authserver.pojo.ResponseData;
import com.bms.authserver.service.ControllerService;
import com.bms.authserver.service.ControllerServiceJpa;

@RestController
public class RegistrationController {
	
	
    @Autowired
    ControllerServiceJpa controllerServiceJpa;
	@Autowired
    ControllerService controllerservice ;
	
	
	@PostMapping("/register")
	public ResponseData registerNewUser(@Valid @RequestBody RegistrationData registrationData, BindingResult bindingResult) throws  ParseException {
		
		if(bindingResult.hasErrors()) {
		List<FieldError> list = bindingResult.getFieldErrors();
		String str = "";
		for(FieldError i:list) {
			str= str+i.getField()+",";
		}
			return new ResponseData(registrationData.getUsername(),"failure",404,str+"cannot be empty");
		}
		
		ResponseData response = controllerservice.validationcheck(registrationData);
		if(response.getStatus().contains("success")) {
			CustomerCredentials cc = controllerServiceJpa.customercredentialsinsertion(registrationData);
			CustomerDetail cd=controllerServiceJpa.customerdetailinsertion(registrationData);
			CustomerAddress ca = controllerServiceJpa.customeraddressinsertion(registrationData);
			AccountDetail ad = controllerServiceJpa.accountdetailinsertion(registrationData); 
		}
		return response;
	}
}
	