package com.dyl.enums;

/**
 * 商品的销售状态
 * @author Administrator
 *
 */
public enum SaleStatus {
	saling(1,"出售中"),
	unsale(0,"售罄");
	
	private int code;
	private String text;
	
	public static SaleStatus format(Integer code) {
		code = code!=null ? code : -1;
		for(SaleStatus ss:SaleStatus.values()) {
			if(code==ss.code) {
				return ss;
			}
		}
		return null;
	}
	
	public static String toText(Integer code) {
		code = code!=null ? code : -1;
		for(SaleStatus ss:SaleStatus.values()) {
			if(code==ss.code) {
				return ss.text;
			}
		}
		return null;
	}
	
	private SaleStatus(int code,String text){
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
