package com.dada.pay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.pay.core.BaseService;
import com.dada.pay.dao.PayAccountDao;
import com.dada.pay.dao.PayAccountMoneyDao;
import com.dada.pay.dao.PayAccountTypeDao;
import com.dada.pay.model.PayAccountModel;
import com.dada.pay.model.PayAccountMoneyModel;
import com.dada.pay.model.PayAccountTypeModel;

@Service
public class AccountService extends BaseService{
	
	@Autowired
	private PayAccountDao _payAccountDao; 
	
	@Autowired
	private PayAccountTypeDao _PayAccountTypeDao;
	
	@Autowired
	private PayAccountMoneyDao _PayAccountMoneyDao;
	
	public Map <String , Object> getAccountDetail(int accountId) {
		PayAccountModel account = _payAccountDao.getById(accountId);
		Map <String, Object> data=new HashMap<String, Object>();
		data.put("accountId", account.getAccountId());
		data.put("accountName", account.getAccountName());
		data.put("status" , account.getStatus());
		
		PayAccountMoneyModel money = _PayAccountMoneyDao.getById(accountId);
		data.put("totalPrice", money.getTotalPrice());
		data.put("extraPrice" , money.getExtraPrice());
		data.put("freezPrice", money.getFreezPrice());
		
		return data;
	}
	
	public int saveAccount(String accountName) {
		PayAccountModel account = new PayAccountModel();
		account.setAccountName(accountName);
		account.setStatus(1);
		int accountId = _payAccountDao.save(account);
		
		PayAccountMoneyModel money = new PayAccountMoneyModel();
		money.setAccountId(accountId);
		money.setTotalPrice(0);
		money.setExtraPrice(0);
		money.setFreezPrice(0);
		_PayAccountMoneyDao.save(money);
		
		return accountId;
	}
	
	
	public void deleteAccount(int accountId) {
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