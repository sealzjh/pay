package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_money_record")
public class PayMoneyRecordModel {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="account_id")
    private int accountId;
    
    @Column(name="value")
    private float value;
    
    @Column(name="type_id")
    private int typeId;
    
    @Column(name="create_time")
    private int createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}


}
