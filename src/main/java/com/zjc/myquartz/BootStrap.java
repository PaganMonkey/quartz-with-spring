package com.zjc.myquartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类，根据timer.xml配置文件执行
 */
@SpringBootApplication
public class BootStrap {

    public static void main( String[] args ) {
		SpringApplication.run(BootStrap.class, args);
    }
    
}
