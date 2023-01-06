package com.cdac.lab11.domain;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class User {
	@Email(message = "email-id format invalid")
	@NotEmpty(message = "email-id must not be empty")
	private String username;
	
	@Pattern(regexp = "(?=.*[@#$%^&*])[A-Za-z0-9@#$%^&*]{8,15}" , 
			message = "min 8 and max 15 characters are required and please enter"
					+ " alphabets from a-z and digits from 0-9 and 1 special charatcer")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
