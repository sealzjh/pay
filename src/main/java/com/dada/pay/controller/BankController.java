package com.dada.pay.controller;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dada.pay.core.BaseController;
import com.dada.pay.core.Response;
import com.dada.pay.service.BankService;

@RestController  
public class BankController extends BaseController {
	
	@Autowired
	private BankService _BankService;

	@RequestMapping("/bank/list/")
    public Response list(){
		List <Map <String , Object>> list = _BankService.getList();
		
		return success(list);
    }
	
	@RequestMapping("/bank/add/")
	public Response add(String bankName) {
		try{
			int id = _BankService.saveBank(bankName);
			return success(id);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}
	
	@RequestMapping("/bank/remove/")
	public Response remove(int bankId) {
		try{
			_BankService.deleteBank(bankId);
			return success(null);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}
	
	@RequestMapping("/bank/update/")
	public Response update(int bankId , String bankName) {
		try{
			_BankService.updateBank(bankId , bankName);
			return success(null);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}
	
	@RequestMapping("/bank/detail/")
	public Response detail(int bankId) {
		try{
			String bankName = _BankService.getBankName(bankId);
		
			Map <String, Object> data=new HashMap<String, Object>();
			data.put("bankId", bankId);
			data.put("bankName", bankName);
		
			return success(data);
		
		} catch(Exception e) {
			return fail(1,"Fail");
		}
	}
	  
}