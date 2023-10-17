package com.example.demo.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Account Table Entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	/** Account ID */
	@Id
	private Integer id;
	
	/** Account Email */
	private String email;
	
	/** Account Username */
	private String username;
	
	/** Account Password */
	private String password;
}
