package com.dada.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dada.pay.core.BaseController;
import com.dada.pay.core.Response;
import com.dada.pay.service.CityService;

@RestController  
public class CityController extends BaseController {  
	
	@Autowired
	private CityService _CityService;
  
	@RequestMapping("/city/list/")  
    public Response cityList(int provinceId){  
		List <Map <String , Object>> list = _CityService.getCityList(provinceId);
        return success(list);
    }
	
	@RequestMapping("/city/detail/")
	public Response cityDetail(int cityId) {
		Map <String , Object> data  = _CityService.getCityDetail(cityId);
		return success(data);
	}
	
	@RequestMapping("/province/list/")
	public Response provinceList() {
		List <Map <String , Object>> list = _CityService.getProvinceList();
		
		return success(list);
	}
	
	@RequestMapping("/province/detail/")
	public Response provinceDetail(int provinceId) {
		String provinceName = _CityService.getProvinceName(provinceId);
		
		Map <String, Object> data=new HashMap<String, Object>();
		data.put("provinceId", provinceId);
		data.put("provinceName", provinceName);
		
		return success(data);
	}
  
}