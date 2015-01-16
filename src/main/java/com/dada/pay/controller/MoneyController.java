package com.dada.pay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class MoneyController {  
  
	@RequestMapping("/money/up/")  
    public String up(){  
        return "money!";  
    }
	
	@RequestMapping("/money/down/")
	public String down() {
		return "down";
	}
	
	@RequestMapping("/money/record/")
	public String moneyRecord() {
		//page pagesize
		return "money record";
	}
  
}