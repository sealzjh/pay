package com.dada.pay.controller;

import java.util.List;
import java.util.Map;

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
    public Response detail(int accountId){  
		
		Map <String , Object> list = _AccountService.getAccountDetail(accountId);
        return success(list);
    }
	
	/**
	 * @param: String accountName
	 * 
	 * */
	@RequestMapping("/account/add/")
	public Response add(String accountName) {
		int id = _AccountService.saveAccount(accountName);
		return success(id);
	}

	/**
	 * @param: int accountName
	 * */
	@RequestMapping("/account/remove/")
	public Response remove(int accountId) {
		_AccountService.deleteAccount(accountId);
		return success(null);
	}
	
	@RequestMapping("/account/typelist/")
	public Response listAccountType() {
		List <Map <String , Object>> list = _AccountService.listAccountType();
		
		return success(list);
	}
  
}