package com.in28minutes.login;

public class LoginService {
	public boolean isUserValid(String name, String password) {
		return name.equals("jmk") && password.equals("password");
	}
}
