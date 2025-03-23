package com.blogApp.Blog_application_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@GetMapping("/user")
	public String HomeUser(@RequestParam String firstName)
	{
		return "Hello World"+ "firstName";
	}

}
