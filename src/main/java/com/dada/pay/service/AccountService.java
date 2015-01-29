package com.dada.pay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.pay.core.BaseService;
import com.dada.pay.dao.PayAccountDao;
import com.dada.pay.dao.PayAccountTypeDao;
import com.dada.pay.model.PayAccountModel;
import com.dada.pay.model.PayAccountTypeModel;

@Service
public class AccountService extends BaseService{
	
	@Autowired
	private PayAccountDao _payAccountDao; 
	
	@Autowired
	private PayAccountTypeDao _PayAccountTypeDao;
	
	public Map <String , Object> getAccountDetail(long accountId) {
		PayAccountModel account = _payAccountDao.getById(accountId);
		Map <String, Object> data=new HashMap<String, Object>();
		data.put("accountId", account.getAccountId());
		data.put("accountName", account.getAccountName());
		data.put("status" , account.getStatus());
		
		return data;
	}
	
	public void saveAccount(String accountName) {
		PayAccountModel account = new PayAccountModel();
		account.setAccountName(accountName);
		account.setStatus(1);
		
		_payAccountDao.save(account);
	}
	
	
	public void deleteAccount(long accountId) {
		PayAccountModel account = _payAccountDao.getById(accountId);
		account.setStatus(0);
		_payAccountDao.update(account);
	}
	
	public List<Map <String , Object>> listAccountType() {
		List <PayAccountTypeModel> list = _PayAccountTypeDao.getList();
		
		List <Map <String , Object>> rs = new ArrayList<Map <String , Object>>();
		for(PayAccountTypeModel item:list) {
			Map <String , Object> data = new HashMap<String , Object>();
			
			data.put("id", item.getId());
			data.put("name", item.getName());
			rs.add(data);
			
		}
		
		return rs;
	}
	
}