package com.dyl.designPattern;

public class AliPay implements PhonePay {

	@Override
	public void pay() {
		System.out.println("使用支付宝支付");
	}

}
