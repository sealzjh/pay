package com.dada.pay.dao;

import java.util.List;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayBankModel;

@Repository
@Transactional
public class PayBankDao extends BaseDao {

	public PayBankModel getById(int id) {
		return (PayBankModel) session().get(PayBankModel.class, id);
	}
	
	public List<PayBankModel> getList() {
		List<PayBankModel> list = session().createCriteria(PayBankModel.class)
											.addOrder( Order.asc("bankId") )
											.list();
		return list;
	}

	public int save(PayBankModel pay) {
		session().save(pay);
		return pay.getBankId();
	}

	public void delete(PayBankModel pay) {
		session().delete(pay);
	}

	public void update(PayBankModel pay) {
		session().update(pay);
	}

}