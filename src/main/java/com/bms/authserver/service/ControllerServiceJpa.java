package com.bms.authserver.service;



import java.util.List;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.authserver.dao.AccountDetailRepository;
import com.bms.authserver.dao.AccountMasterRepository;
import com.bms.authserver.dao.CustomerAddressRepository;
import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.dao.CustomerDetailRepository;
import com.bms.authserver.models.AccountDetail;
import com.bms.authserver.models.AccountMaster;
import com.bms.authserver.models.CustomerAddress;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.models.CustomerDetail;
import com.bms.authserver.pojo.RegistrationData;
import com.bms.authserver.util.CommonUtils;

@Service
public class ControllerServiceJpa {
	
	@Autowired
	CustomerCredentialsRepository customerCredentialsRepository;
	
	@Autowired
	CustomerAddressRepository   customerAddressRepository;
	
	@Autowired
	CustomerDetailRepository   customerDetailRepository;
	
	@Autowired
	AccountDetailRepository accountDetailRepository;
	
	@Autowired
	AccountMasterRepository accountMasterRepository;
	
	
	public CustomerCredentials customercredentialsinsertion(RegistrationData obj) {
		CustomerCredentials cc= new CustomerCredentials(obj.getUsername(),CommonUtils.bcryptPasswordEncoder(obj.getPassword()));
		customerCredentialsRepository.save(cc);
		return cc;
	}
	public CustomerDetail customerdetailinsertion(RegistrationData obj) throws ParseException {
		CustomerCredentials cc = customerCredentialsRepository.findByUsername(obj.getUsername()); 
		CustomerDetail cd= new CustomerDetail(cc,obj.getFirstName(),obj.getLastName(),obj.getEmail(),obj.getGender(), new SimpleDateFormat("dd/MM/yyyy").parse(obj.getDob()),obj.getContact(),obj.getPan());
		customerDetailRepository.save(cd);
		return cd;
	}
	public CustomerAddress customeraddressinsertion(RegistrationData obj) {
		
		CustomerCredentials cc = customerCredentialsRepository.findByUsername(obj.getUsername());
		CustomerDetail cd = customerDetailRepository.getById(cc.getId());
		CustomerAddress ca = new CustomerAddress(cd,obj.getAddress(),obj.getCity(),obj.getState(),obj.getPincode(),obj.getCountry(),"Y");
		customerAddressRepository.save(ca);
		return ca;
	}
	public AccountDetail accountdetailinsertion(RegistrationData obj) {
		CustomerCredentials cc = customerCredentialsRepository.findByUsername(obj.getUsername());
		CustomerDetail cd = customerDetailRepository.getById(cc.getId());
		AccountMaster am1 = accountMasterRepository.findByAccountType(obj.getAccountType());
        int rand = new Random().nextInt((999999999 - 100) + 1) + 10;
        if(am1==null) {
        	am1 = new AccountMaster(obj.getAccountType());
        }
        AccountDetail ad = new AccountDetail(cd,String.valueOf(rand),am1);
        accountDetailRepository.save(ad);
        return ad;
	}
	public boolean isUsernameAvailable(String username) {
		CustomerCredentials customerCredentials = customerCredentialsRepository.findByUsername(username);
		if(customerCredentials == null)
			return true;
		else
		return false;
	}
	
}
