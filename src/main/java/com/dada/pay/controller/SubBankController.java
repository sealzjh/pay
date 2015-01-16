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
	public Response list(long bankId , long cityId) {
		List <Map <String , Object>> list = _BankService.getSubbankList(bankId , cityId);
		
		return success(list);
	}
	
	@RequestMapping("/subbank/add/")
	public Response add(long bankId , long cityId , String bankName) {
		
		_BankService.saveSubbank(bankId , cityId , bankName);
		return success(null);
	}
	
	@RequestMapping("/subbank/remove/")
	public Response remove(long subbankId) {
		
		_BankService.deleteSubbank(subbankId);
		return success(null);
	}
	
	@RequestMapping("/subbank/detail/")
	public Response detail(long subbankId) {
		Map <String , Object> data  = _BankService.getSubbankDetail(subbankId);
		return success(data);
	}
	
}