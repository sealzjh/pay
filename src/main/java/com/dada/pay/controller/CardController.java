package com.dada.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dada.pay.core.BaseController;
import com.dada.pay.core.Response;
import com.dada.pay.service.CardService;

import java.util.List;
import java.util.Map;

@RestController  
public class CardController extends BaseController {  
	
	@Autowired
	private CardService _CardService;
  
	/**
	 * @param: int accountId
	 * @param: string accountName
	 * @param: string accountCard
	 * @param: int accountTypeId
	 * @param: int payBankId
	 * @param: int payCityId
	 * @param: string payCityName
	 * @param: int paySubbankId
	 * @param: string paySubbankName
	 * 
	 * */
	@RequestMapping("/card/add/")  
    public Response add(int accountId ,String accountName , String accountCard , int accountTypeId,
    					int payBankId , int payCityId , String payCityName , int paySubbankId , String paySubbankName){
		
		int id = _CardService.saveCard(accountId , accountName , accountCard , accountTypeId , payBankId , payCityId , payCityName,
				paySubbankId , paySubbankName);
        return success(id);
    }
	
	@RequestMapping("/card/remove/")
	public Response remove(int cardId) {
		_CardService.deleteCard(cardId);
		return success(null);
	}
	
	@RequestMapping("/card/list/")
	public Response list(int accountId) {
		List <Map <String , Object>> list = _CardService.getAccountCard(accountId);
		return success(list);
	}
	
	@RequestMapping("/card/default/")
	public Response getDefault(int accountId) {
		Map <String , Object> data = _CardService.getDefaultCard(accountId);
		return success(data);
	}
	
	@RequestMapping("/card/defaultCard/")
	public Response defaultCard(int accountId , int cardId) {
		_CardService.setDefault(accountId , cardId);
		return success(null);
	}
  
}