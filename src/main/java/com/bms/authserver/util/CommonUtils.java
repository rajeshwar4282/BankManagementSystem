package com.bms.authserver.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class CommonUtils {

	private CommonUtils() {
		
	}
	public static  String bcryptPasswordEncoder(String password) {
	
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	
	
	
	}