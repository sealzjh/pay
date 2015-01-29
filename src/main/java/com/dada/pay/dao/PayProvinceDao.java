package com.dada.pay.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayProvinceModel;

@Repository
@Transactional
public class PayProvinceDao extends BaseDao {
	public PayProvinceModel getById(int id) {
		return (PayProvinceModel) session().get(PayProvinceModel.class, id);
	}
	
	public List<PayProvinceModel> getList() {
		List<PayProvinceModel> list = session().createCriteria(PayProvinceModel.class)
											.addOrder( Order.asc("provinceId") )
											.list();
		return list;
	}
	
}