package com.dyl.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("jobDataMapBean")
public class JobDataMapBean {

	public void anotherSysout(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		System.out.println("JobDataMapBean invoked..."+sdf.format(date));
	}
}
