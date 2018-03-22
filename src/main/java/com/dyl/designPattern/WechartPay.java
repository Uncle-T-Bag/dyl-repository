package com.dyl.designPattern;

public class WechartPay implements PhonePay {

	@Override
	public void pay() {
		System.out.println("使用微信支付");
	}

}
