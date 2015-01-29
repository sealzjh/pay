package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_subbank")
public class PaySubbankModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="subbank_id")
    private int subbankId;

    @Column(name="subbank_name")
    private String subbankName;
    
    @Column(name="bank_id")
    private int bankId;
    
    @Column(name="city_id")
    private int cityId;

	public int getSubbankId() {
		return subbankId;
	}

	public void setSubbankId(int subbankId) {
		this.subbankId = subbankId;
	}

	public String getSubbankName() {
		return subbankName;
	}

	public void setSubbankName(String subbankName) {
		this.subbankName = subbankName;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
