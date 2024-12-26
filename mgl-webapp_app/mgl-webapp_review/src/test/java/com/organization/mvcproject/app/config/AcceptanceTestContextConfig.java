//package com.organization.mvcproject.app.config;
//
//import java.lang.invoke.MethodHandles;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import com.organization.mvcproject.test.MGLSpringTestContext;
//import com.organization.mvcproject.test.WebDriverConfig;
//
//import io.cucumber.java.Before;
//import io.cucumber.spring.CucumberContextConfiguration;
//import jakarta.annotation.PostConstruct;
//
////@SpringJUnitConfig(classes = MGLWebApplicationInitializer.class )
//@CucumberContextConfiguration
//@SpringJUnitConfig(classes = {WebDriverConfig.class, MGLSpringTestContext.class, ServerContextConfig.class})
//@Import(WebDriverConfig.class)
//public class AcceptanceTestContextConfig {
//    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//
//    @Before
//    void contextLoads() {
//        logger.info("----------------- Spring Context Initialized for Executing Cucumber Tests ------------------");
//    }
//    
//}
