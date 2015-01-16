package com.dada.pay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class AccountController {  
  
	@RequestMapping("/account/detail/")  
    public String detail(){  
        return "account!";  
    }
	
	@RequestMapping("/account/add/")
	public String add() {
		return "add";
	}
	
	@RequestMapping("/account/remove/")
	public String remove() {
		return "remove";
	}
  
}