package com.dada.pay.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayAccountMoneyModel;


@Repository
@Transactional
public class PayAccountMoneyDao extends BaseDao {
	
	public PayAccountMoneyModel getById(int accountId) {
		return (PayAccountMoneyModel) session().get(PayAccountMoneyModel.class, accountId);
	}

	public void save(PayAccountMoneyModel money) {
		session().save(money);
	}
	
	public void update(PayAccountMoneyModel money) {
		session().update(money);
	}
	
}