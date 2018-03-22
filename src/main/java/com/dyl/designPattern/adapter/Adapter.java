package com.dyl.designPattern.adapter;
//Adapter适配器类继承Source又实现Targetable接口，这样他同时拥有method1和method2方法了
public class Adapter extends Source implements Targetable{

	@Override
	public void method2() {
		System.out.println("this is my method2!!!");	
	}

}
