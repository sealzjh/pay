package com.dada.pay.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayAccountModel;


@Repository
@Transactional
public class PayAccountDao extends BaseDao {
	
	public PayAccountModel getById(int id) {
		return (PayAccountModel) session().get(PayAccountModel.class, id);
	}
	
	public int save(PayAccountModel pay) {
		session().save(pay);
		return pay.getAccountId();
	}

	public void delete(PayAccountModel pay) {
		session().delete(pay);
	}

	public void update(PayAccountModel pay) {
		session().update(pay);
	}
	
}