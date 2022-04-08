package com.bms.authserver.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.authserver.pojo.RegistrationData;
import com.bms.authserver.pojo.ResponseData;
@Service
public class ControllerService {
	
	@Autowired
	ControllerServiceJpa controllerServiceJpa;
	public ResponseData validationcheck( RegistrationData data) {
		
		ResponseData response = new ResponseData(data.getUsername(),"success",200,"successfully registered!");
		String msg ="";
		boolean valid = true;
		if(usernameavailability(data.getUsername())) {
			
		  if(!isValidUsername(data.getUsername())) {
				  valid = false;
				  msg=msg+"please enter a valid username (cannot be phone number / email id /cannot contain special characters )";
		  }
		  if(!isValidPassword(data.getPassword())) {
			  valid = false;
			  msg=msg+"password doesn't meet criteria!";
		  }
		  if(!isValidNames(data.getFirstName())) {
			  valid = false;
			  msg=msg+"please enter a valid firstname!";
		  }
		  if(!isValidNames(data.getLastName())) {
			  valid = false;
			  msg=msg+"please enter a valid lastname!";
		  }
		  if(!isValidEmailId(data.getEmail())) {
			  valid = false;
			  msg=msg+"please enter a valid email id!";
		  }
		  if(!isValidDate(data.getDob())) {
			  valid = false;
			  msg=msg+"please enter a valid dob!";
		  }
		  if(!isValidPhoneNumber(data.getContact())) { 
			  valid = false;
			  msg=msg+"please enter a valid phone number!";
		  }
			 
		  if(!isValidPanNumber(data.getPan())) {
			  valid = false;
			  msg=msg+"please enter a valid pan number!";
		  }
		  if(!isValidPinCode(data.getPincode())) {
			  valid = false;
			  msg=msg+"please enter a valid pincode!";
		  }
		  if(!isValidAccountType(data.getAccountType().toLowerCase())) {
			  valid=false;
			  msg=msg+"please enter a valid accounttype (savings/current/loanaccount)";
		  }
		  
			
		}
		else {
			response.setCode(400); 
			response.setMessage("username is not available");
			response.setStatus("failure");
		}
		
		
		if(!valid) {
			response.setCode(300);
			response.setMessage(msg);
			response.setStatus("failure");
		}
		
		return response;
	}
	//function for checking username availability
	public boolean usernameavailability(String username ) {
		return controllerServiceJpa.isUsernameAvailable(username);
	}	

	public static boolean isValidUsername(String username) {
		String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(username);
        return m.matches();
	}
	//function for checking password criteria
	public static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        Pattern p = Pattern.compile(regex);
  
        
        Matcher m = p.matcher(password);
        return m.matches();
    }
	//function for checking firstname,lastname
	public static boolean isValidNames(String name) {
		return name.matches( "[A-Z][a-z]*" );
	}
	//function for validating email id
	public static boolean isValidEmailId(String email ) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}
	//function for validating dob
	public static boolean isValidDate(String d)
    {
        String regex = "^(1[0-2]|0[1-9])/(3[01]"
                       + "|[12][0-9]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)d);
        return matcher.matches();
    }
	//function for validating phone number
	public static boolean isValidPhoneNumber(String s) {
		
		Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
		
	}
	//function for pan number validation
	public static boolean isValidPanNumber(String panCardNo) {
		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(panCardNo);
        return m.matches();
	}
	//function to check pincode validation
	public static boolean isValidPinCode(String pincode1)
	{
	    Pattern p = Pattern.compile("^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$");
	    Matcher m = p.matcher(pincode1);
        return m.matches();
	    
	}
	public static boolean isValidAccountType(String accountType) {
		
		
		if(accountType.equals("savings") || accountType.contains("current") || accountType.contains("loanaccount"))
			return true;
		
		
		return false;
	}
}
