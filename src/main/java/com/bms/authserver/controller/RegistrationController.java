package com.bms.authserver.controller;

import java.net.BindException;

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
import com.bms.authserver.service.Controllerservice;

@RestController
public class RegistrationController {
	
	@Autowired
	CustomerCredentialsRepository customerCredentialsRepository;

	private  Controllerservice controllerservice = new Controllerservice();
	
	@PostMapping("/register")
	public <ResponseEntity>ResponseData registerNewUser(@Valid @RequestBody RegistrationData registrationData, BindingResult bindingResult) throws BindException {
		
		
		ResponseData response = controllerservice.validationcheck(registrationData);
		if(response.getStstus()=="success") {
			CustomerCredentials cc= new CustomerCredentials(registrationData.getUsername(),registrationData.getPassword());
		   customerCredentialsRepository.save(cc);
		}
		return response;
	}

}
