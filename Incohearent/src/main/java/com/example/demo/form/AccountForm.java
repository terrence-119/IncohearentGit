package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountForm {
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Length(min=8,max=20)
	private String username;
	
	@NotBlank
	@Length(min=8,max=20)
	private String password;
}
