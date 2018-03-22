package com.dyl.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 自定义spring能识别的QuartzJobBean
 * @author Administrator
 *
 */
public class SpringQuartzJob extends QuartzJobBean {

	private JobDataMapBean jobDataMap;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		System.out.println("SpringQuartzJob executeInternal..."+sdf.format(date));
		this.jobDataMap.anotherSysout();
	}
	
	public void setJobDataMap(JobDataMapBean jobDataMap) {
		this.jobDataMap = jobDataMap;
	}

	
}
