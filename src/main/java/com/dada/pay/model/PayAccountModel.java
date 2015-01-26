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
    private long accountId;

    @Column(name="account_name")
    private String accountName;
    
    @Column(name="status")
    private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long id) {
        this.accountId = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

}
