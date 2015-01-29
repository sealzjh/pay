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
    private float totalPrice;
    
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

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
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
