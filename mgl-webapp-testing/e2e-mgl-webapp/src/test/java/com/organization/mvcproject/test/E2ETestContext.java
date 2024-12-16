package com.organization.mvcproject.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.organization.mvcproject.pom.POMContextConfig;
import com.organization.mvcproject.pom.annotation.PageObjectModel;

@Configuration
@ComponentScan(
    basePackages = {
        "com.organization.mvcproject.test",
        "com.organization.mvcproject.test.bdd"
    },
    includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = PageObjectModel.class
    )
)
public class E2ETestContext extends POMContextConfig {
	
//    @Bean
//    @DependsOn("webDriver") 
//    public MGLMainNavMenu mainNavMenu(WebDriver driver) {
//        return new MGLMainNavMenu(driver);
//    }
	
}