package com.bms.authserver.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bms.authserver.AuthServerApplication;
import com.bms.authserver.pojo.RegistrationData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AuthServerApplication.class })
class RegistrationControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wc;
	static ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() throws JsonProcessingException, Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
	@Test
	public void customercredentialaTest1() throws JsonProcessingException, Exception {
		RegistrationData obj = new RegistrationData();
		obj.setAccountType("savings");
		obj.setAddress("main road,duddenapally");
		obj.setCity("karimnagar");
		obj.setContact("9177144155");
		obj.setCountry("india");
		obj.setDob("10/10/1999");
		obj.setEmail("rohithshiv@gmail.com");
		obj.setFirstName("rajeshwar");
        obj.setGender("male");
        obj.setLastName("shivanathri");
        obj.setPan("JBVPS5610D");
        obj.setPassword("Rohith@4282");
        obj.setPincode(505472);
        obj.setState("telangana");
        obj.setUsername("rohith4282");
        String json = MAPPER.writeValueAsString(obj);
		MvcResult andReturn = mockMvc
				.perform(MockMvcRequestBuilders.post("/register")
						.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200)).andReturn();
		
	}
}
