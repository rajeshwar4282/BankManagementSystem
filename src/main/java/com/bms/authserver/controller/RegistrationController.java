package com.bms.authserver.controller;

import java.net.BindException;
import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.models.CustomerCredentials;
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
	public <ResponseEntity>ResponseData registerNewUser(@Valid @RequestBody RegistrationData registrationData, BindingResult bindingResult) throws BindException, ParseException {
		
		
		ResponseData response = controllerservice.validationcheck(registrationData);
		if(response.getStstus()=="success") {
			controllerServiceJpa.customercredentialsinsertion(registrationData);
			//controllerServiceJpa.customerdetailsinsertion(registrationData);
		}
		return response;
	}
}
	