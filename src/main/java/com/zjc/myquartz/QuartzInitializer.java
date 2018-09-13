package com.zjc.myquartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.zjc.myquartz.conf.QuartzConfig;
import com.zjc.myquartz.conf.Timer;

/**
 * @description 根据timer.xml配置文件设置定时任务
 */
@Component
public class QuartzInitializer implements InitializingBean{

	private Scheduler scheduler;
	private QuartzConfig config;
	
	public QuartzInitializer(Scheduler scheduler, QuartzConfig config){
		this.scheduler = scheduler;
		this.config = config;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(null!=config.getConfigDto() && null!=config.getConfigDto().getTimers()) {
			for (Timer timer : config.getConfigDto().getTimers()) {
				if(Boolean.valueOf(timer.getEnable())) {
					JobDetail jobDetail = newJob((Class<Job>)Class.forName(timer.getType()))
			                .withIdentity(timer.getName(), "group1")
			                .storeDurably(true)
			                .build();
					
					scheduler.addJob(jobDetail, false);
					
					if(Boolean.valueOf(timer.getStartOnBoot())) {
						Trigger simpleTrigger = newTrigger()
				                .withIdentity(timer.getName()+"simpleTrigger", "group1")
				                .startNow()
				                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
				                        .withRepeatCount(0))
				                .forJob(jobDetail)
				                .build();	
						scheduler.scheduleJob(simpleTrigger);
					}
					
					if(null!=timer.getCron() && timer.getCron().length()>0){
						Trigger cronTrigger = newTrigger()
				                .withIdentity(timer.getName()+"crontrigger", "group1")
				                .startNow()
				                .withSchedule(CronScheduleBuilder.cronSchedule(timer.getCron()))
				                .forJob(jobDetail)
				                .build();
						scheduler.scheduleJob(cronTrigger);
					}
				}
			}
		}
	}
}
