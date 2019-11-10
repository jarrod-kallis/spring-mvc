package com.in28minutes.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value = "/login") // URL to this method
	@ResponseBody // Send the return as the response body
	public String sayHello() {
		return "Hello World";
	}
}
