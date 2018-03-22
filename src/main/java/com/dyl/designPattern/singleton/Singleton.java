package com.dyl.designPattern.singleton;
/**
 * 一个完美的单例模式
 * @author Administrator
 *
 */
public class Singleton {
	
	private static Singleton instance = null;
	
	//私有化构造方法，防止程序创建
	private Singleton() {}
	
	private static synchronized void synInit() {
		if(instance == null) {
			instance = new Singleton();
		}
	}
	//将创建实例和get实例分开达到线程安全
	public static Singleton getInstance() {
		if(instance == null) {
			synInit();
		}
		return instance;
	}
	
}
