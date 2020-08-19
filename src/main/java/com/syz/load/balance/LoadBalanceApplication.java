package com.syz.load.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoadBalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalanceApplication.class, args);
	}

}
