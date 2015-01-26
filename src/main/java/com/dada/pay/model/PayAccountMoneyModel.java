package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_account_money")
public class PayAccountMoneyModel {

    @Id
    @Column(name="account_id")
    private int accountId;

    @Column(name="total_price")
    private float total_price;
    
    @Column(name="freez_price")
    private float freezPrice;
    
    @Column(name="extra_price")
    private float extraPrice;
    
    public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public float getFreezPrice() {
		return freezPrice;
	}

	public void setFreezPrice(float freezPrice) {
		this.freezPrice = freezPrice;
	}

	public float getExtraPrice() {
		return extraPrice;
	}

	public void setExtraPrice(float extraPrice) {
		this.extraPrice = extraPrice;
	}


}
