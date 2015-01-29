package com.dada.pay.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dada.pay.core.BaseController;
import com.dada.pay.core.Response;
import com.dada.pay.service.MoneyService;

@RestController  
public class MoneyController extends BaseController {  
	
	@Autowired
	private MoneyService _MoneyService;
  
	/**
	 * @param: int accountId
	 * @param: double price
	 * @param: int typeId
	 * */
	@RequestMapping("/money/up/")  
    public Response moneyUp(int accountId , int orderId , int typeId , float price){  
		_MoneyService.moneyUp(accountId, orderId, typeId, price);
        return success(null);  
    }
	
	@RequestMapping("/money/down/")
	public Response moneyDown(int accountId , int orderId , int typeId , float price){  
		_MoneyService.moneyDown(accountId, orderId, typeId, price);
        return success(null);  
	}
	
	@RequestMapping("/money/record/")
	public Response moneyRecord(int accountId ,int orderId , int page , int pageSize) {
		int start = 0;
		start = (page - 1) * pageSize;
		if(start < 0) {
			start = 0;
		}
		
		List <Map <String , Object>> list = _MoneyService.getList(accountId, orderId, start, pageSize);
		return success(list);
	}
	
}