package com.dada.pay.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PaySubbankModel;


@Repository
@Transactional
public class PaySubbankDao extends BaseDao {

	public PaySubbankModel getById(int id) {
		return (PaySubbankModel) session().get(PaySubbankModel.class, id);
	}
	
	public List<PaySubbankModel> getList(int bankId , int cityId) {
		List<PaySubbankModel> list = session().createCriteria(PaySubbankModel.class)
											.add( Restrictions.eq("bankId", bankId ) )
											.add( Restrictions.eq("cityId", cityId ) )
											.addOrder( Order.asc("subbankId") )
											.list();
		return list;
	}

	public int save(PaySubbankModel pay) {
		session().save(pay);
		return pay.getSubbankId();
	}

	public void delete(PaySubbankModel pay) {
		session().delete(pay);
	}

	public void update(PaySubbankModel pay) {
		session().update(pay);
	}
}