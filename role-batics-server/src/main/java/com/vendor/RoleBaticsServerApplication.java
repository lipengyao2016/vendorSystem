package com.vendor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.vendor.mapper")
@ComponentScan(basePackages = {"com.vendor.controller","com.vendor.service"})
public class RoleBaticsServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(RoleBaticsServerApplication.class, args);
	}

}
