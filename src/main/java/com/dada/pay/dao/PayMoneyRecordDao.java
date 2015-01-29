package com.dada.pay.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayMoneyRecordModel;


@Repository
@Transactional
public class PayMoneyRecordDao extends BaseDao {
	
	public List <PayMoneyRecordModel> getList(int accountId , int orderId , int start , int pageSize) {
		Criteria criteria = session().createCriteria(PayMoneyRecordModel.class)
									.add(Restrictions.eq("accountId" , accountId));
		
		if (orderId > 0) {
			criteria = criteria.add(Restrictions.eq("orderId" , orderId));
		}
		
		criteria.setMaxResults(pageSize);
		criteria.setFirstResult(start);
		criteria.addOrder(Order.desc("id"));
		
		List <PayMoneyRecordModel> list = criteria.list();
		
		return list;
	}

	public void save(PayMoneyRecordModel record) {
		session().save(record);
	}
	
}