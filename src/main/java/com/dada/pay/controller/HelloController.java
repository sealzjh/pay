package com.dada.pay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dada.pay.core.BaseController;

@RestController  
public class HelloController extends BaseController {  
	
	@RequestMapping(value="/hello/" , method = RequestMethod.GET)  
    public String hello(){ 		
		return "Hello";
    }
  
}