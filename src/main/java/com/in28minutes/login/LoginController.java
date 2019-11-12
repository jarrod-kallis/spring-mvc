package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// Whenever you put an attribute with the name "name" into the model map
// it will automatically become available throughout the user's session
@SessionAttributes("name")
public class LoginController {

	// The spring framework will inject an instance of the login service
	// automagically
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET) // URL to this
																	// method
	// @ResponseBody // Send the return as the response body
	public String showLoginScreen() { // The actual method name doesn't matter
		// return "Hello World";
		return "login"; // Refers to the JSP
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam(value = "name") String name, @RequestParam String password,
			ModelMap model) {
		if (loginService.isUserValid(name, password)) {
			model.put("name", name);
			return "welcome";
		} else {
			model.put("errorMessage", "Invalid credentials");
			return "login";
		}
	}
}
