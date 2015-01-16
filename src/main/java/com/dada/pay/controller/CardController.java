package com.dada.pay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class CardController {  
  
	@RequestMapping("/card/add/")  
    public String add(){  
        return "card!";  
    }
	
	@RequestMapping("/card/remove/")
	public String remove() {
		return "remove";
	}
	
	@RequestMapping("/card/list/")
	public String list() {
		//by account id
		return "list";
	}
	
	@RequestMapping("/card/defaultCard/")
	public String defaultCard() {
		return "Default";
	}
  
}