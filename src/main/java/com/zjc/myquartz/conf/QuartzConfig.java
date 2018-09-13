package com.zjc.myquartz.conf;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

@Component
public class QuartzConfig extends BaseConfig{
	
	private static Unmarshaller unmarshaller;
	private ConfigDto configDto;
	
	static {
		try {
			JAXBContext context = JAXBContext.newInstance(ConfigDto.class);
			unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public QuartzConfig() {
		openFile("/timer.xml");
	}

	@Override
	protected boolean init(InputStream input) throws Exception {
		configDto = (ConfigDto) unmarshaller.unmarshal(input);
		return true;
	}

	public ConfigDto getConfigDto() {
		return configDto;
	}
	
}
