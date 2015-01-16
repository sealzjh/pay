package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_subbank")
public class PaySubbankModel {

    @Id
    @Column(name="subbank_id")
    private long subbankId;

    @Column(name="subbank_name")
    private String subbankName;
    
    @Column(name="bank_id")
    private long bankId;
    
    @Column(name="city_id")
    private long cityId;

	public long getSubbankId() {
		return subbankId;
	}

	public void setSubbankId(long subbankId) {
		this.subbankId = subbankId;
	}

	public String getSubbankName() {
		return subbankName;
	}

	public void setSubbankName(String subbankName) {
		this.subbankName = subbankName;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

}
