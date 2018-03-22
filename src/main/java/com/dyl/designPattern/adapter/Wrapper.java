package com.dyl.designPattern.adapter;

public class Wrapper implements Targetable{
	//引用源对象，达到兼容的目的
	private Source source;
	
	public Wrapper(Source source) {
		this.source = source;
	}
	
	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is my method2!");
	}

}
