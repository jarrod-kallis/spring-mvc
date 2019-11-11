package com.in28minutes.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

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
		model.put("name", name);
		return "welcome";
	}
}
