package com.dyl.quartz;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 自定义的任务单元（相当于job）
 * @author Administrator
 *
 */
@Component("myQuartzBean")
public class MyQuartzBean {

	public void sysoutMethod(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		System.out.println("myQuartzBean invoked..."+sdf.format(date));
	}
}
