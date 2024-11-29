package com.organization.mvcproject.test;

import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.event.ContextRefreshedEvent;

import com.organization.mvcproject.pom.annotation.PageObjectModel;
import com.organization.mvcproject.pom.common.MGLMainNavMenu;

@Configuration
@ComponentScan(
    basePackages = {
        "com.organization.mvcproject.pom",
        "com.organization.mvcproject.pom.annotation",
        "com.organization.mvcproject.pom.common", 
        "com.organization.mvcproject.pom.games",
        "com.organization.mvcproject.test",
        "com.organization.mvcproject.test.bdd.steps"
    },
    includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = PageObjectModel.class
    )
)
public class MGLSpringTestContext {
	
    @Bean
    @DependsOn("webDriver")  // Add this
    public MGLMainNavMenu mainNavMenu(WebDriver driver) {
        return new MGLMainNavMenu(driver);
    }
	
    @Bean
    public ApplicationListener<ContextRefreshedEvent> logBeans(ApplicationContext applicationContext) {
        return event -> {
            System.out.println("=== All beans loaded: ===");
            Stream.of(applicationContext.getBeanDefinitionNames())
                .sorted()
                .forEach(System.out::println);
            System.out.println("=== End beans list ===");
        };
    }
}