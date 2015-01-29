package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_bank")
public class PayBankModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bank_id" ,unique=true)
    private int bankId;

    @Column(name="bank_name")
    private String bankName;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int id) {
        this.bankId =  id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


}
