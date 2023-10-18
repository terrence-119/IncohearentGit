package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Account;
import com.example.demo.form.AccountForm;
import com.example.demo.service.AccountService;


@Controller
@RequestMapping("/Incohearent")
public class IncohearentViewController 
{
	/** DI対象 */
	@Autowired
	AccountService service;
	
	/** 「form-backing bean」の初期化 */
	@ModelAttribute("Incohearent/index")
	public AccountForm setUpForm()
	{
		return new AccountForm();
	}
	
	@GetMapping("index")
	public String indexView(AccountForm accountForm, Model model)
	{
		return "index";
	}
	
	@PostMapping("confirm")
	public String confirmView(@Validated AccountForm accountForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
	{
		//FormからEntityへの変換
		Account account = new Account();
		account.setEmail(accountForm.getEmail());
		account.setUsername(accountForm.getUsername());
		account.setPassword(accountForm.getPassword());
		
		if (!bindingResult.hasErrors())
		{
			service.insertAccount(account);
			return "confirm";
		}
		else
		{
			return "index";
		}
	}
}
