package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.AccountForm;


@Controller
@RequestMapping("Incohearent")
public class IncohearentViewController 
{
	
	@GetMapping("index")
	public String indexView()
	{
		return "index";
	}
	
	/** 「form-backing bean」の初期化 */
	@ModelAttribute
	public AccountForm setUpForm()
	{
		return new AccountForm();
	}
	
	@PostMapping("confirm")
	public String confirmView(@Validated AccountForm form, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return "index";
		}
		
		return "confirm";
	}
}
