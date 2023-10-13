package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Incohearent")
public class IncohearentViewController {
	
	@GetMapping("index")
	public String indexView()
	{
		return "index";
	}
}
