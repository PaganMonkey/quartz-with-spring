package com.zjc.quartz_with_spring;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
	
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
