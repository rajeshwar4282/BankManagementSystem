package com.bms.authserver.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.dao.CustomerDetailRepository;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.models.CustomerDetail;
import com.bms.authserver.pojo.RegistrationData;

@Service
public class ControllerServiceJpa {
	
	@Autowired
	CustomerCredentialsRepository customerCredentialsRepository;
	@Autowired
	CustomerDetailRepository   customerDetailRepository;
	
	public void customercredentialsinsertion(RegistrationData obj) {
		CustomerCredentials cc= new CustomerCredentials(obj.getUsername(),obj.getPassword());
		   customerCredentialsRepository.save(cc);
	} 
	
	public void customerdetailsinsertion(RegistrationData obj) throws ParseException {
		CustomerCredentials cc= new CustomerCredentials(obj.getUsername(),obj.getPassword());
		Date date1 = null;
		date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(obj.getDob());  
		CustomerDetail cd= new CustomerDetail(cc,obj.getFirstName(),obj.getLastName(),obj.getEmail(),obj.getGender(),date1,obj.getContact(),obj.getPan());
		

		customerDetailRepository.save(cd);
	}
}
