package com.dada.pay.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dada.pay.core.BaseController;
import com.dada.pay.core.Response;
import com.dada.pay.service.BankService;

@RestController 
class SubBankController extends BaseController {
	
	@Autowired
	private BankService _BankService;
	
	@RequestMapping("/subbank/list/")
	public Response list(int bankId , int cityId) {
		List <Map <String , Object>> list = _BankService.getSubbankList(bankId , cityId);
		
		return success(list);
	}
	
	@RequestMapping("/subbank/add/")
	public Response add(int bankId , int cityId , String bankName) {
		try{
			int id = _BankService.saveSubbank(bankId , cityId , bankName);
			return success(id);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}
	
	@RequestMapping("/subbank/remove/")
	public Response remove(int subbankId) {
		
		try{
			_BankService.deleteSubbank(subbankId);
			return success(null);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}
	
	@RequestMapping("/subbank/detail/")
	public Response detail(int subbankId) {
		try {
			Map <String , Object> data  = _BankService.getSubbankDetail(subbankId);
			return success(data);
		} catch(Exception e) {
			return fail(1 , "Fail");
		}
	}
	
}