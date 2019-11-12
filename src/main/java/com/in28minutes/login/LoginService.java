package com.in28minutes.login;

import org.springframework.stereotype.Service;

// Have the spring framework manage this class 
// ie. create an instance, inject it where necessary
@Service
public class LoginService {
	public boolean isUserValid(String name, String password) {
		return name.equals("user") && password.equals("user");
	}
}
