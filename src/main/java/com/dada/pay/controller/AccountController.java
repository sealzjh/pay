package com.dada.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dada.pay.core.BaseController;
import com.dada.pay.core.Response;
import com.dada.pay.service.AccountService;

@RestController  
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService _AccountService;
  
	@RequestMapping("/account/detail/")  
    public String detail(){  
        return "account!";  
    }
	
	/**
	 * @param: String accountName
	 * 
	 * */
	@RequestMapping("/account/add/")
	public Response add(String accountName) {
		_AccountService.saveAccount(accountName);
		return success(null);
	}

	/**
	 * @param: int accountName
	 * */
	@RequestMapping("/account/remove/")
	public Response remove(long accountId) {
		_AccountService.deleteAccount(accountId);
		return success(null);
	}
  
}