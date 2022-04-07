package com.bms.authserver.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import com.bms.authserver.pojo.ResponseData;
import com.bms.authserver.service.ControllerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AuthServerApplication.class })
public class RegistrationControllerTest {


private MockMvc mockMvc;

@Autowired
private WebApplicationContext wc;



static ObjectMapper MAPPER = new ObjectMapper();

@Before
public void setUp() throws JsonProcessingException, Exception {
	mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
}

@Test
public void saveCustomer() throws JsonProcessingException, Exception {
	
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","success",200,"successfully registered!");	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
ControllerService controllerservice = new ControllerService();

//testing for suucessful validation
@Test
public void check1() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","success",200,"successfully registered!");	
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
//testing for password validation
@Test
public void check2() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","rohith4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","failure",400,"password doesn't meet criteria!");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
//testing for email id validation
@Test
public void check3() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathgmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid email id!");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
//test case for phone number validation
@Test
public void check4() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"91771155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid phone number!");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
//test case for pan validation
@Test
public void check5() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"9177144155","JBVPS56D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","current");
	ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid pan number!");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
// test case fro pin code validatioln
@Test
public void check6() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","50572","loanaccount");
	ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid pincode!");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
//test case for username validation
@Test
public void check7() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("admin","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","failure",400,"username is not available");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
//testcase for handling multiple validations
@Test
public void check8() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","rohith4282","Rajeshwar","Shivanathri","rohithshivanathrigmail.com","male",date,"9144155","JBVPS50D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","failure",400,"password doesn't meet criteria!please enter a valid email id!please enter a valid phone number!please enter a valid pan number!");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
@Test
public void check9() {
	String date="01/06/199";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","failure",400,"please enter a valid dob!");
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}

@Test
public void check10() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","nothing");
	ResponseData response = new ResponseData("rohith4282","success",200,"please enter a valid accounttype (savings/current/loanaccount)");	
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
@Test
public void check11() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","rajes1hwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","success",200,"please enter a valid firstname!");	
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
@Test
public void check12() {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith4282","Rohith@4282","Rajeshwar","shivanathri","rohtihshivanatrhi@gmail.com","male",date,"9177144155","jbvps5610d","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith4282","success",200,"please enter a valid lastname!please enter a valid pan number!");	
	assertEquals(response.getMessage(),controllerservice.validationcheck(data).getMessage());
}
}