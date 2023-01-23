package com.organization.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.organization.provider"})
public class MglProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MglProviderApplication.class, args);
	}

}
