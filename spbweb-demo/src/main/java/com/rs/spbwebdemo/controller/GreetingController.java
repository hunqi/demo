package com.rs.spbwebdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@RequestMapping(value = "/hello")
	public String hello(){
		return "Hello world!";
	}
	
	@RequestMapping(value = "/goodMorning")
	public String goodMoring(){
		return "Good morning!";
	}
	
}