package com.dada.pay.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayCityModel;


@Repository
@Transactional
public class PayCityDao extends BaseDao {
	
	public PayCityModel getById(long id) {
		return (PayCityModel) session().get(PayCityModel.class, id);
	}
	
	public List<PayCityModel> getList(long provinceId) {
		List<PayCityModel> list = session().createCriteria(PayCityModel.class)
											.add( Restrictions.eq("provinceId", provinceId ) )
											.addOrder( Order.asc("cityId") )
											.list();
		return list;
	}
	
}