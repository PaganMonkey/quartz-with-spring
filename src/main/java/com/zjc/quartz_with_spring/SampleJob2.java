package com.hundsun.macs.quartz_with_spring;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/*
 * 任务类 QuartzJobBean是对job的实现
 */
public class SampleJob2 extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("yyyyy");
	}

}
