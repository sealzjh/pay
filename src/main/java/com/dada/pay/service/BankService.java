package com.dada.pay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.pay.core.BaseService;
import com.dada.pay.dao.PayBankDao;
import com.dada.pay.dao.PaySubbankDao;
import com.dada.pay.model.PayBankModel;
import com.dada.pay.model.PaySubbankModel;

import java.util.List;

@Service
public class BankService extends BaseService{
	@Autowired
	private PayBankDao _bankDao; 
	
	@Autowired
	private PaySubbankDao _PaySubbankDao;
	
	public void saveBank(String bankName) {
		PayBankModel pay = new PayBankModel();
		pay.setBankName(bankName);
		_bankDao.save(pay);
	}
	
	public String getBankName(long bankId) {
		PayBankModel bank = _bankDao.getById(bankId);
		String bankName = String.valueOf(bank.getBankName());
		
		return bankName;
	}
	
	public List<Map <String , Object>> getList() {
		List <PayBankModel> list = (List<PayBankModel>) _bankDao.getList();
		
		List<Map<String, Object>> rs=new ArrayList<Map <String , Object>>();
		
		for(PayBankModel item:list) {
			Map <String, Object> data=new HashMap<String, Object>();
			data.put("bankId", item.getBankId());
			data.put("bankName", item.getBankName());
			rs.add(data);
		}
		
		return rs;
	}

	public void updateBank(long bankId , String bankName) {
		PayBankModel pay = _bankDao.getById(bankId);
		pay.setBankName(bankName);
		_bankDao.update(pay);
	}
	
	public void deleteBank(long bankId) {
		PayBankModel pay = _bankDao.getById(bankId);
		_bankDao.delete(pay);
	}
	
	public void saveSubbank(long bankId , long cityId , String bankName) {
		PaySubbankModel pay = new PaySubbankModel();
		pay.setBankId(bankId);
		pay.setCityId(cityId);
		pay.setSubbankName(bankName);
		
		_PaySubbankDao.save(pay);
	}
	
	public void deleteSubbank(long subbankId) {
		PaySubbankModel pay = _PaySubbankDao.getById(subbankId);
		_PaySubbankDao.delete(pay);
	}
	
	public Map <String , Object> getSubbankDetail(long cityId) {
		PaySubbankModel subbank = _PaySubbankDao.getById(cityId);
		Map <String, Object> data=new HashMap<String, Object>();
		data.put("subbankId" , subbank.getBankId());
		data.put("subbankName" , subbank.getSubbankName());
		data.put("bankId" , subbank.getBankId());
		data.put("cityId", subbank.getCityId());
		
		return data;
	}
	
	public List<Map <String , Object>> getSubbankList(long bankId , long cityId) {
		List <PaySubbankModel> list = (List<PaySubbankModel>) _PaySubbankDao.getList(bankId, cityId);
		
		List<Map<String, Object>> rs=new ArrayList<Map <String , Object>>();
		
		for(PaySubbankModel item:list) {
			Map <String, Object> data=new HashMap<String, Object>();
			data.put("subbankId" , item.getBankId());
			data.put("subbankName" , item.getSubbankName());
			data.put("bankId" , item.getBankId());
			data.put("cityId", item.getCityId());
			rs.add(data);
		}
		
		return rs;
	}
	
	
}