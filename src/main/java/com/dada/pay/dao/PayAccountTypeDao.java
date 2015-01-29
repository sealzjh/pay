package com.dada.pay.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayAccountTypeModel;


@Repository
@Transactional
public class PayAccountTypeDao extends BaseDao {
	
	public List <PayAccountTypeModel> getList() {
		List <PayAccountTypeModel> list = session().createCriteria(PayAccountTypeModel.class)
											.addOrder(Order.asc("id"))
											.list();
	
	return list;
	
	}
	
}