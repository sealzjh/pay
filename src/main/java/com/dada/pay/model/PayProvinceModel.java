package com.dada.pay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pay_province")
public class PayProvinceModel {

    @Id
    @Column(name="province_id")
    private long provinceId;

    @Column(name="province_name")
    private String provinceName;

	public long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}
