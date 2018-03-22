package com.dyl.domain;

import java.math.BigDecimal;
import java.util.Date;


public class Goods {

	private Integer id;
	private String goodName;
	private BigDecimal goodPrice;
	private String description;
	private String goodNumber;
	private String madeCountry;
	private Date createTime;
	private Date updateTime;
	private Integer flag;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public BigDecimal getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGoodNumber() {
		return goodNumber;
	}
	public void setGoodNumber(String goodNumber) {
		this.goodNumber = goodNumber;
	}
	public String getMadeCountry() {
		return madeCountry;
	}
	public void setMadeCountry(String madeCountry) {
		this.madeCountry = madeCountry;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodName=" + goodName + ", goodPrice=" + goodPrice + ", description="
				+ description + "\n, goodNumber=" + goodNumber + ", madeCountry=" + madeCountry + ", createTime="
				+ createTime + "\n, updateTime=" + updateTime + ", flag=" + flag + "]";
	}
	
}
