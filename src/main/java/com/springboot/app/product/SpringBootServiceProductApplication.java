package com.springboot.app.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.springboot.app.commons.model"})
public class SpringBootServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceProductApplication.class, args);
	}

}
