package com.zjc.myquartz.conf;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @description 
 */
@XmlRootElement(name = "timers")  
@XmlAccessorType(XmlAccessType.FIELD) 
public class ConfigDto {
	
	@XmlElements(value = { @XmlElement(name = "timer") })
	private List<Timer> timers;

	public List<Timer> getTimers() {
		return timers;
	}

	public void setTimers(List<Timer> timers) {
		this.timers = timers;
	}
	
}
