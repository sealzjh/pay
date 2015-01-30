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
		try{
			Map <String , Object> list = _AccountService.getAccountDetail(accountId);
        	return success(list);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
    }
	
	/**
	 * @param: String accountName
	 * 
	 * */
	@RequestMapping("/account/add/")
	public Response add(String accountName) {
		try{
			int id = _AccountService.saveAccount(accountName);
			return success(id);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}

	/**
	 * @param: int accountName
	 * */
	@RequestMapping("/account/remove/")
	public Response remove(int accountId) {
		try{
			_AccountService.deleteAccount(accountId);
			return success(null);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}
	
	@RequestMapping("/account/typelist/")
	public Response listAccountType() {
		List <Map <String , Object>> list = _AccountService.listAccountType();
		
		return success(list);
	}
  
}