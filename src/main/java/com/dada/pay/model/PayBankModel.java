package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_bank")
public class PayBankModel {

    @Id
    @Column(name="bank_id")
    private long bankId;

    @Column(name="bank_name")
    private String bankName;

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long id) {
        this.bankId =  id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


}
