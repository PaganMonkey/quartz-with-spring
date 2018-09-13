package com.zjc.myquartz.conf;

import java.io.IOException;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 配置文件读取
 */
public class BaseConfig {
	private static final Logger logger = LoggerFactory.getLogger(BaseConfig.class);

	protected boolean openFile(String fileName) {
		InputStream in = null;

		try {
			in = this.getClass().getResourceAsStream(fileName);
			boolean e = this.init(in);
			return e;
		} catch (Exception arg12) {
			logger.error(fileName + " read error.", arg12);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException arg11) {
					logger.error(fileName + " close error.", arg11);
				}

				in = null;
			}

		}

		return false;
	}

	protected boolean init(InputStream input) throws Exception {
		return true;
	}
}
