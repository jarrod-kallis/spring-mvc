package com.in28minutes.jee;

public class UserService {
	public static boolean isUserValid(String name, String password) {
		return name.equals("jmk") && password.equals("password");
	}
}
