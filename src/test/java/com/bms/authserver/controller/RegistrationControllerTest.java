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
	RegistrationData data = new RegistrationData("rohith2767","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith2767","success",200,"successfully registered!");	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
    
}

@Test
public void saveCustomer1() throws JsonProcessingException, Exception {
	
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith14415","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith14415","failure",400,"username is not available. Please enter another username.");	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals( mvcResult.getResponse().getContentAsString(),json1);
}


ControllerService controllerservice = new ControllerService();

//testing for suucessful validation
//@Test
//public void check1() throws Exception {
//	String date="01/06/1999";
//	RegistrationData data = new RegistrationData("rohith42821","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
//	ResponseData response = new ResponseData("rohith42821","success",200,"successfully registered!");	
//	
//	String json = MAPPER.writeValueAsString(data);
//	String json1 = MAPPER.writeValueAsString(response);
//	MvcResult mvcResult = mockMvc
//			.perform(MockMvcRequestBuilders.post("/register")
//					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//			.andReturn();
//    assertEquals(json1, mvcResult.getResponse().getContentAsString());
//	
//}
//testing for password validation
@Test
public void check2() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith42822","rohith4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith42822","failure",300,"password doesn't meet criteria!");
	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
    
}
//testing for email id validation
@Test
public void check3() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith42823","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathgmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith42823","failure",300,"please enter a valid email id!");
	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
//test case for phone number validation
@Test
public void check4() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith42824","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"91771155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith42824","failure",300,"please enter a valid phone number!");
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
//test case for pan validation
@Test
public void check5() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith42825","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"9177144155","JBVPS56D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","current");
	ResponseData response = new ResponseData("rohith42825","failure",300,"please enter a valid pan number!");
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
// test case fro pin code validatioln
@Test
public void check6() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith42826","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","50572","loanaccount");
	ResponseData response = new ResponseData("rohith42826","failure",300,"please enter a valid pincode!");
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}

//testcase for handling multiple validations
@Test
public void check8() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith42827","rohith4282","Rajeshwar","Shivanathri","rohithshivanathrigmail.com","male",date,"9144155","JBVPS50D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith42827","failure",300,"password doesn't meet criteria!please enter a valid email id!please enter a valid phone number!please enter a valid pan number!");
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
@Test
public void check9() throws Exception {
	String date="01/06/199";
	RegistrationData data = new RegistrationData("rohith42828","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanath@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith42828","failure",300,"please enter a valid dob!");
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}

@Test
public void check10() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith42829","Rohith@4282","Rajeshwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","nothing");
	ResponseData response = new ResponseData("rohith42829","failure",300,"please enter a valid accounttype (savings/current/loanaccount)");	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
@Test
public void check11() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith428210","Rohith@4282","rajes1hwar","Shivanathri","rohithshivanathri@gmail.com","male",date,"9177144155","JBVPS5610D","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith428210","failure",300,"please enter a valid firstname!");	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
@Test
public void check12() throws Exception {
	String date="01/06/1999";
	RegistrationData data = new RegistrationData("rohith428211","Rohith@4282","Rajeshwar","shivanathri","rohtihshivanatrhi@gmail.com","male",date,"9177144155","jbvps5610d","3-42 minaroad duudenapally","karimnagar","telangana","india","505472","savings");
	ResponseData response = new ResponseData("rohith428211","failure",300,"please enter a valid lastname!please enter a valid pan number!");	
	String json = MAPPER.writeValueAsString(data);
	String json1 = MAPPER.writeValueAsString(response);
	MvcResult mvcResult = mockMvc
			.perform(MockMvcRequestBuilders.post("/register")
					.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
			.andReturn();
    assertEquals(json1, mvcResult.getResponse().getContentAsString());
}
}