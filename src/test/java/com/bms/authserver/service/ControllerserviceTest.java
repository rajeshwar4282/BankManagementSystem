package com.bms.authserver.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.bms.authserver.pojo.RegistrationData;
import com.bms.authserver.pojo.ResponseData;

public class ControllerserviceTest {
    
	 Controllerservice controllerservice = new Controllerservice();
	 //testing for suucess
	@Test
    void check1() {
		Date date = new Date(2000, 11, 21);
		RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","rajeshwar","shivanathri","rohithshivanathri@gmail.com","male",date,Long.parseLong("9177144155"),"JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india",505472,"savings");
		ResponseData response = new ResponseData("rohith4282","success",200,"successfully registered! ");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
	//testing for password validation
	@Test
    void check2() {
		Date date = new Date(0);
		RegistrationData data = new RegistrationData("rohith4282","rohith4282","rajeshwar","shivanathri","rohithshivanathri@gmail.com","male",date,Long.parseLong("9177144155"),"JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india",505472,"savings");
		ResponseData response = new ResponseData("rohith4282","failure",400,"password doesnt meet criteria! ");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
	//testing for email id validation
	@Test
    void check3() {
		Date date = new Date(0);
		RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","rajeshwar","shivanathri","rohithshivanathgmail.com","male",date,Long.parseLong("9177144155"),"JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india",505472,"savings");
		ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid email id! ");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
	//test case for phone number validation
	@Test
    void check4() {
		Date date = new Date(0);
		RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","rajeshwar","shivanathri","rohithshivanath@gmail.com","male",date,Long.parseLong("91771445"),"JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india",505472,"savings");
		ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid phone number! ");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
	//test case for pan validation
	@Test
    void check5() {
		Date date = new Date(0);
		RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","rajeshwar","shivanathri","rohithshivanath@gmail.com","male",date,Long.parseLong("9177144155"),"JBVPS56D","3-42 minaroad duudenapally","karimnagar","telangana","india",505472,"savings");
		ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid pan number! ");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
	// test case fro pin code validatioln
	@Test
    void check6() {
		Date date = new Date(0);
		RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","rajeshwar","shivanathri","rohithshivanath@gmail.com","male",date,Long.parseLong("9177144155"),"JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india",50542,"savings");
		ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid pincode! ");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
	//test case for username validation
	@Test
    void check7() {
		Date date = new Date(0);
		RegistrationData data = new RegistrationData("admin","Rohith@4282","rajeshwar","shivanathri","rohithshivanathri@gmail.com","male",date,Long.parseLong("9177144155"),"JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india",505472,"savings");
		ResponseData response = new ResponseData("rohith4282","failure",400,"username is not available");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
	//testcase for handling multiple validations
	@Test
    void check8() {
		Date date = new Date(0);
		RegistrationData data = new RegistrationData("rohith4282","rohith4282","rajeshwar","shivanathri","rohithshivanathrigmail.com","male",date,Long.parseLong("91771441"),"JBVPS50D","3-42 minaroad duudenapally","karimnagar","telangana","india",505472,"savings");
		ResponseData response = new ResponseData("rohith4282","failure",400,"password doesnt meet criteria! please enter a valid email id! please enter a valid phone number! please enter a valid pan number! ");
		assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
	}
}
