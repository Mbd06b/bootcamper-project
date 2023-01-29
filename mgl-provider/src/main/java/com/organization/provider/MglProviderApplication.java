package com.organization.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.organization.provider"})
@EntityScan({"com.organization.provider.model"})
public class MglProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MglProviderApplication.class, args);
	}

}
