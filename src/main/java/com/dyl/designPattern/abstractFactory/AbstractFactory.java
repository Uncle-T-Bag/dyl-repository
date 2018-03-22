package com.dyl.designPattern.abstractFactory;

import com.dyl.designPattern.PhonePay;
//抽象工厂接口
public interface AbstractFactory {
	//用来创建实例对象的抽象方法
	PhonePay produce();
}
