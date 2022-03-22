package com.bms.authserver.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bms.authserver.pojo.RegistrationData;

class RegistrationControllerTest {

	@Test
	void registerTest1() {
		String uri = "/register";
		
		RegistrationData registrationData = 
				new RegistrationData("ranjit", "aser@987", "ranjit", "jadhav", "ion@smair.com",
						"male", null, 9878, "ASJH1928J", "Abac chs", 
						"mumbai", "maharashtra", "india", 400015, "loan");
		
		
		
	}
}
