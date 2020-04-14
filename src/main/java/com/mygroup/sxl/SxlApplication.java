package com.mygroup.sxl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
@MapperScan("com.mygroup.sxl.scheduler.dao")
public class SxlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SxlApplication.class, args);
	}


}
