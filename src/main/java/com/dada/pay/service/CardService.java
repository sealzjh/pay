package com.dada.pay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.pay.core.BaseService;
import com.dada.pay.dao.PayCardDao;
import com.dada.pay.model.PayCardModel;


@Service
public class CardService extends BaseService{
	@Autowired
	private PayCardDao _PayCardDao;
	
	public int saveCard(int accountId ,String accountName , String accountCard , int accountTypeId,
    					int payBankId , int payCityId , String payCityName , int paySubbankId , String paySubbankName) {
		
		PayCardModel card = new PayCardModel();
		card.setAccountId(accountId);
		card.setAccountName(accountName);
		card.setAccountCard(accountCard);
		card.setAccountTypeId(accountTypeId);
		card.setPayBankId(payBankId);
		card.setPayCityId(payCityId);
		card.setPayCityName(payCityName);
		card.setPaySubbankId(paySubbankId);
		card.setPaySubbankName(paySubbankName);
		
		return _PayCardDao.save(card);
	}
	
	public void deleteCard(int cardId) {
		PayCardModel card = _PayCardDao.getById(cardId);
		_PayCardDao.delete(card);
	}
	
	public void setDefault(int accountId , int cardId) {
		List <PayCardModel> list = (List<PayCardModel>) _PayCardDao.getDefaultCard(accountId);
		for(PayCardModel item:list) {
			item.setIsDefault(0);
			_PayCardDao.update(item);
			
		}
		
		PayCardModel card = _PayCardDao.getById(cardId);
		card.setIsDefault(1);
		_PayCardDao.update(card);
	}
	
	public List<Map <String , Object>> getAccountCard(int accountId) {
		List <PayCardModel> list = (List<PayCardModel>) _PayCardDao.getAccountCard(accountId);
		
		List <Map <String , Object>> rs = new ArrayList<Map <String , Object>>();
		
		for(PayCardModel item:list) {
			Map <String , Object> data = new HashMap<String , Object> ();
			data.put("cardId", item.getCardId());
			data.put("accountId" , item.getAccountId());
			data.put("accountName", item.getAccountName());
			data.put("accountCard", item.getAccountCard());
			data.put("accountTypeId", item.getAccountTypeId());
			data.put("payBankId", item.getPayBankId());
			data.put("payCityId", item.getPayCityId());
			data.put("payCityName", item.getPayCityName());
			data.put("paySubbankId", item.getPaySubbankId());
			data.put("paySubbankName", item.getPaySubbankName());
			data.put("isDefault" , item.getIsDefault());
			
			rs.add(data);
		}
		
		return rs;
	}
	
	public Map <String , Object> getDefaultCard(int accountId) {
		List <PayCardModel> list = (List<PayCardModel>) _PayCardDao.getDefaultCard(accountId);
		
		Map <String , Object> data = new HashMap<String , Object> ();
		
		for(PayCardModel item:list) {
			data.put("cardId", item.getCardId());
			data.put("accountId" , item.getAccountId());
			data.put("accountName", item.getAccountName());
			data.put("accountCard", item.getAccountCard());
			data.put("accountTypeId", item.getAccountTypeId());
			data.put("payBankId", item.getPayBankId());
			data.put("payCityId", item.getPayCityId());
			data.put("payCityName", item.getPayCityName());
			data.put("paySubbankId", item.getPaySubbankId());
			data.put("paySubbankName", item.getPaySubbankName());
			data.put("isDefault", item.getIsDefault());
		}
		
		return data;
		
	}
	
	
}