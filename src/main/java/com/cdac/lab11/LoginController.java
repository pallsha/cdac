package com.cdac.lab11;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.lab11.dao.UserDao;

import com.cdac.lab11.domain.User;

@Controller
public class LoginController {
	
	UserDao userDao;
	@Autowired
	LoginController(UserDao ud){
		this.userDao = ud;
	}
	@RequestMapping(value = "/validate-user" , 
			method = RequestMethod.POST)
	public String validateUser(@Valid @ModelAttribute("usr") User user, BindingResult result, ModelMap map) { 
		if(!result.hasErrors()) {
			if ( userDao.validateUser(user)) {
				map.addAttribute("Message", "hello");
				map.addAttribute("Greeting", "Good Morning");
				return "lab11-home";
			}
			else {
				map.addAttribute("Message", "No such user found!");
				return "lab11-error";
			}
		}else {
			map.addAttribute("Message", "Invalid username or passowrd!");
			return "lab11-error";
		}
	}
}
