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

    @Column(name="total")
    private float total;
    
    @Column(name="freez_total")
    private float freezTotal;
    
    @Column(name="cash_total")
    private float cashTotal;
    
    public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getFreezTotal() {
		return freezTotal;
	}

	public void setFreezTotal(float freezTotal) {
		this.freezTotal = freezTotal;
	}

	public float getCashTotal() {
		return cashTotal;
	}

	public void setCashTotal(float cashTotal) {
		this.cashTotal = cashTotal;
	}

}
