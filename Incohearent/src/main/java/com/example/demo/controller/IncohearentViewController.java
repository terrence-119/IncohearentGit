package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.Form;


@Controller
@RequestMapping("Incohearent")
public class IncohearentViewController {
	
	@GetMapping("index")
	public String indexView()
	{
		return "index";
	}
	
	@PostMapping("confirm")
	public String confirmView(Form f)
	{
		return "confirm";
	}
}
