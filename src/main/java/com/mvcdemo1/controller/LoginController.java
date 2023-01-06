package com.mvcdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/check-user" , 
			method = RequestMethod.POST)
	
	public ModelAndView checkUser(@RequestParam("username") String uname,
			@RequestParam("password") String pass) {
		
		ModelAndView mv = null;
		
		if(uname.equals("pallavi@gmail.com") && pass.equals("efg@123")) {
			mv = new ModelAndView("home", "uname" , uname);
		}
		else {
			mv = new ModelAndView("error", "MESSAGE" , 
					"invalid login credentials");
		}
		
		return mv;
	}
	
}








