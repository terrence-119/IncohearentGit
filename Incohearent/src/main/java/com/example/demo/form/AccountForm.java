package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import com.example.demo.entity.Account;

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
	
	
	public void toEntity(Account account)
	{
		account.setId(null);
		account.setEmail(email);
		account.setUsername(username);
		account.setPassword(password);
	}
}
