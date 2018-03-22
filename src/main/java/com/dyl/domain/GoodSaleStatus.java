package com.dyl.domain;

import com.dyl.enums.SaleStatus;

public class GoodSaleStatus {

	private Integer goodsId;
	private SaleStatus saleStatus;
	
	public GoodSaleStatus() {}
	
	public GoodSaleStatus(Integer goodsId, SaleStatus saleStatus) {
		super();
		this.goodsId = goodsId;
		this.saleStatus = saleStatus;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public SaleStatus getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(SaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}
	
	
}
