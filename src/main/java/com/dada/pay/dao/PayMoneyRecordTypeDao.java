package com.dada.pay.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dada.pay.core.BaseDao;
import com.dada.pay.model.PayMoneyRecordTypeModel;


@Repository
@Transactional
public class PayMoneyRecordTypeDao extends BaseDao {

	public PayMoneyRecordTypeModel getById(int id) {
		return (PayMoneyRecordTypeModel) session().get(PayMoneyRecordTypeModel.class, id);
	}
	
}