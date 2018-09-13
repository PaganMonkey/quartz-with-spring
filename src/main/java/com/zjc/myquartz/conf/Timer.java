package com.zjc.myquartz.conf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD) 
public class Timer {
	
	@XmlAttribute(name = "enable") 
	private String enable;
	@XmlAttribute(name = "name") 
	private String name;
	@XmlAttribute(name = "type") 
	private String type;
	@XmlAttribute(name = "cron") 
	private String cron;
	@XmlAttribute(name = "start-on-boot") 
	private String startOnBoot;
	
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartOnBoot() {
		return startOnBoot;
	}
	public void setStartOnBoot(String startOnBoot) {
		this.startOnBoot = startOnBoot;
	}
	
}
