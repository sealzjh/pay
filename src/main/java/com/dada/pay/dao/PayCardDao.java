package com.dada.pay.dao;

import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayCardModel;


@Repository
@Transactional
public class PayCardDao extends BaseDao {
	
	public PayCardModel getById(int id) {
		return (PayCardModel) session().get(PayCardModel.class , id);
	}
	
	public List<PayCardModel> getAccountCard(int accountId) {
		List<PayCardModel> list = session().createCriteria(PayCardModel.class)
											.add(Restrictions.eq("accountId" , accountId))
											.addOrder(Order.asc("cardId"))
											.list();
		
		return list;
	}
	
	public List<PayCardModel> getDefaultCard(int accountId) {
		List<PayCardModel> list = session().createCriteria(PayCardModel.class)
											.add(Restrictions.eq("accountId" , accountId))
											.add(Restrictions.eq("isDefault" , 1))
//											.setMaxResults(1)
											.list();
		return list;
	}
	
	public int save(PayCardModel card) {
		session().save(card);
		return card.getCardId();
	}
	
	public void delete(PayCardModel card) {
		session().delete(card);
	}

	public void update(PayCardModel card) {
		session().update(card);
	}
	
}