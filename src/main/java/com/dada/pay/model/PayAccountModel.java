package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_account")
public class PayAccountModel {

    @Id
    @Column(name="account_id")
    private int accountId;

    @Column(name="account_name")
    private String accountName;
    
    @Column(name="status")
    private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int id) {
        this.accountId = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
