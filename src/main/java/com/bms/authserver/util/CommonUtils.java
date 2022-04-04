package com.bms.authserver.util;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class CommonUtils {

	private CommonUtils() {
		
	}
	public static  String bcryptPasswordEncoder(String password) {
	
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	
	
	public static String passwordEncoder(String password) {

		String pepper = "pepper"; // secret key used by password encoding
		int iterations = 200000;  // number of hash iteration
		int hashWidth = 256;      // hash width in bits

		Pbkdf2PasswordEncoder pbkdf2PasswordEncoder =new Pbkdf2PasswordEncoder(pepper, iterations, hashWidth);
		pbkdf2PasswordEncoder.setEncodeHashAsBase64(true);
		
		return pbkdf2PasswordEncoder.encode(password);
	  }
	}