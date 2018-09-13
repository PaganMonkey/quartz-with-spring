package com.hundsun.macs.quartz_with_spring;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bean配置
 * 由于spring已经生成了Scheduler，所以只需要提供JobDetail和Trigger就可以了
 * Scheduler依赖注入所有Trigger bean
 */
@Configuration
public class Config {
	
	@Bean
	@Qualifier("jobDetail")
	public JobDetail getJobDetail(){
		JobDetail jobDetail = newJob(SampleJob.class)
                .withIdentity("job1", "group1")
                .storeDurably(true)
                .build();
		return jobDetail;
	}
	
	@Bean
	public Trigger getSimpleTrigger(@Qualifier("jobDetail") JobDetail jobDetail){
		Trigger trigger = newTrigger()
                .withIdentity("job1-simpletrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withRepeatCount(0))
                .forJob(jobDetail)
                .build();
		return trigger;
	}
	
	@Bean
	public Trigger getCronTrigger(@Qualifier("jobDetail") JobDetail jobDetail){
		Trigger trigger = newTrigger()
                .withIdentity("job1-crontrigger", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/46 8-19 * * ?"))
                .forJob(jobDetail)
                .build();
		return trigger;
	}
	
	
	@Bean
	@Qualifier("jobDetail2")
	public JobDetail getJobDetail2(){
		JobDetail jobDetail = newJob(SampleJob2.class)
                .withIdentity("job2", "group1")
                .storeDurably(true)
                .build();
		return jobDetail;
	}
	
	@Bean
	public Trigger getSimpleTrigger2(@Qualifier("jobDetail2") JobDetail jobDetail){
		Trigger trigger = newTrigger()
                .withIdentity("job2-simpletrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withRepeatCount(0))
                .forJob(jobDetail)
                .build();
		return trigger;
	}
}
