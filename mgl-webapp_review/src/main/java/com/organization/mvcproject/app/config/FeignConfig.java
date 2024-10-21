package com.organization.mvcproject.app.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;

@Profile("feign")
@Configuration
@Import(FeignClientProperties.FeignClientConfiguration.class)  
@ComponentScan(basePackages = {
	    "com.organization.provider.endpoint",
	    "com.organization.dao" 
	})
@EnableFeignClients(basePackages = "com.organization.provider.endpoint")
public class FeignConfig {

	
    @Bean
    public FeignClientProperties feignClientProperties() {
        return new FeignClientProperties();
    }
    
    // Your existing beans
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    
    @Bean
    public ObjectFactory<HttpMessageConverters> messageConverters() {
        HttpMessageConverters converters = new HttpMessageConverters(
            new MappingJackson2HttpMessageConverter(objectMapper())
        );
        return () -> converters;
    }
    
    @Bean
    public Decoder feignDecoder() {
        return new SpringDecoder(messageConverters());
    }
    
    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(messageConverters());
    }
    
    @Bean
    public Contract feignContract() {
        return new SpringMvcContract();
    }



}
