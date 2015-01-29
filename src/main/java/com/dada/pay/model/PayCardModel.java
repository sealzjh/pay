package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_card")
public class PayCardModel {

    @Id
    @Column(name="card_id")
    private long cardId;

    @Column(name="account_id")
    private int accountId;
    
    @Column(name="account_name")
    private String accountName;
    
    @Column(name="account_card")
    private String accountCard;
    
    @Column(name="account_type_id")
    private int accountTypeId;
    
    @Column(name="pay_bank_id")
    private int payBankId;
    
    @Column(name="pay_city_id")
    private int payCityId;
    
    @Column(name="pay_city_name")
    private String payCityName;
    
    @Column(name="pay_subbank_id")
    private int paySubbankId;
    
    @Column(name="pay_subbank_name")
    private String paySubbankName;
    
    @Column(name="is_default")
    private int isDefault;

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountCard() {
		return accountCard;
	}

	public void setAccountCard(String accountCard) {
		this.accountCard = accountCard;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public int getPayBankId() {
		return payBankId;
	}

	public void setPayBankId(int payBankId) {
		this.payBankId = payBankId;
	}

	public int getPayCityId() {
		return payCityId;
	}

	public void setPayCityId(int payCityId) {
		this.payCityId = payCityId;
	}

	public String getPayCityName() {
		return payCityName;
	}

	public void setPayCityName(String payCityName) {
		this.payCityName = payCityName;
	}

	public int getPaySubbankId() {
		return paySubbankId;
	}

	public void setPaySubbankId(int paySubbankId) {
		this.paySubbankId = paySubbankId;
	}

	public String getPaySubbankName() {
		return paySubbankName;
	}

	public void setPaySubbankName(String paySubbankName) {
		this.paySubbankName = paySubbankName;
	}

}
