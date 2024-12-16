package com.organization.mvcproject.pom;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.event.ContextRefreshedEvent;

import com.organization.mvcproject.pom.annotation.PageObjectModel;

@Configuration
@ComponentScan(
    basePackages = {
        "com.organization.mvcproject.pom",
        "com.organization.mvcproject.pom.annotation",
        "com.organization.mvcproject.pom.common", 
        "com.organization.mvcproject.pom.games"
    },
    includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = PageObjectModel.class
    )
)
public class POMContextConfig {
	

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