package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IncohearentViewController {
	
	@GetMapping("index")
	public String indexView()
	{
		return "index";
	}
}
