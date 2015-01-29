package com.dada.pay.service;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.pay.core.BaseService;
import com.dada.pay.dao.PayAccountMoneyDao;
import com.dada.pay.dao.PayMoneyRecordDao;
import com.dada.pay.dao.PayMoneyRecordTypeDao;
import com.dada.pay.model.PayAccountMoneyModel;
import com.dada.pay.model.PayMoneyRecordModel;
import com.dada.pay.model.PayMoneyRecordTypeModel;

@Service
public class MoneyService extends BaseService{
	
	@Autowired
	private PayMoneyRecordDao _PayMoneyRecordDao;
	
	@Autowired
	private PayMoneyRecordTypeDao _PayMoneyRecordTypeDao;
	
	@Autowired
	private PayAccountMoneyDao _PayAccountMoneyDao;
	
	public void moneyUp(int accountId , int orderId , int typeId , float price) {
		PayMoneyRecordTypeModel recordType = _PayMoneyRecordTypeDao.getById(typeId);
		String typeName = recordType.getName();
		
		PayAccountMoneyModel accountMoney = _PayAccountMoneyDao.getById(accountId);
		accountMoney.setTotalPrice(accountMoney.getTotalPrice()+price);
		_PayAccountMoneyDao.update(accountMoney);
		
		PayMoneyRecordModel record = new PayMoneyRecordModel();
		record.setAccountId(accountId);
		record.setValue(price);
		record.setTypeId(typeId);
		record.setTypeName(typeName);
		record.setOrderId(orderId);
		_PayMoneyRecordDao.save(record);
		
	}
	
	public void moneyDown(int accountId , int orderId , int typeId , float price) {
		PayMoneyRecordTypeModel recordType = _PayMoneyRecordTypeDao.getById(typeId);
		String typeName = recordType.getName();
		
		PayAccountMoneyModel accountMoney = _PayAccountMoneyDao.getById(accountId);
		accountMoney.setTotalPrice(accountMoney.getTotalPrice()-price);
		_PayAccountMoneyDao.update(accountMoney);
		
		PayMoneyRecordModel record = new PayMoneyRecordModel();
		record.setAccountId(accountId);
		record.setValue(-price);
		record.setTypeId(typeId);
		record.setTypeName(typeName);
		record.setOrderId(orderId);
		_PayMoneyRecordDao.save(record);
	}
	
	public List <Map <String , Object>> getList(int accountId , int orderId , int start , int pageSize) {
		List <PayMoneyRecordModel> list = (List <PayMoneyRecordModel>) _PayMoneyRecordDao.getList(accountId, orderId, start, pageSize);
	
		List <Map <String , Object>> rs = new ArrayList<Map <String , Object>>();
		
		for(PayMoneyRecordModel item:list) {
			Map <String , Object> data = new HashMap<String , Object>();
			data.put("id" , item.getId());
			data.put("accountId", item.getAccountId());
			data.put("value", item.getValue());
			data.put("typeId", item.getTypeId());
			data.put("typeName", item.getTypeName());
			data.put("orderId",item.getOrderId());
			
			rs.add(data);
		}
		
		return rs;
	}
	
}