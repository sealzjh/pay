package com.dada.pay.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.pay.core.BaseService;
import com.dada.pay.dao.PayCityDao;
import com.dada.pay.dao.PayProvinceDao;
import com.dada.pay.model.PayCityModel;
import com.dada.pay.model.PayProvinceModel;

@Service
public class CityService extends BaseService{
	
	@Autowired
	private PayProvinceDao _PayProvinceDao;
	
	@Autowired
	private PayCityDao _PayCityDao;

	public List<Map <String , Object>> getProvinceList() {
		List <PayProvinceModel> list = (List<PayProvinceModel>) _PayProvinceDao.getList();
		
		List<Map<String, Object>> rs=new ArrayList<Map <String , Object>>();
		
		for(PayProvinceModel item:list) {
			Map <String, Object> data=new HashMap<String, Object>();
			data.put("provinceId", item.getProvinceId());
			data.put("provinceName", item.getProvinceName());
			rs.add(data);
		}
		
		return rs;
	}
	
	public String getProvinceName(int provinceId) {
		PayProvinceModel province = _PayProvinceDao.getById(provinceId);
		String ProvinceName = String.valueOf(province.getProvinceName());
		
		return ProvinceName;
	}
	
	public List<Map <String , Object>> getCityList(int provinceId) {
		List <PayCityModel> list = (List<PayCityModel>) _PayCityDao.getList(provinceId);
		
		List<Map<String, Object>> rs=new ArrayList<Map <String , Object>>();
		
		for(PayCityModel item:list) {
			Map <String, Object> data=new HashMap<String, Object>();
			data.put("cityId", item.getCityId());
			data.put("cityCode", item.getCityCode());
			data.put("cityName" , item.getCityName());
			data.put("provinceId" , item.getProvinceId());
			rs.add(data);
		}
		
		return rs;
	}
	
	public Map <String , Object> getCityDetail(int cityId) {
		PayCityModel city = _PayCityDao.getById(cityId);
		Map <String, Object> data=new HashMap<String, Object>();
		data.put("cityId", city.getCityId());
		data.put("cityCode", city.getCityCode());
		data.put("cityName" , city.getCityName());
		data.put("provinceId" , city.getProvinceId());
		
		return data;
	}
}