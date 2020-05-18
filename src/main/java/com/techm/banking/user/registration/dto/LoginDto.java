package com.techm.banking.user.registration.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDto {

	private String userName;
	private String email;
	private String password;

	public LoginDto() {
	}

	public LoginDto(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
}
