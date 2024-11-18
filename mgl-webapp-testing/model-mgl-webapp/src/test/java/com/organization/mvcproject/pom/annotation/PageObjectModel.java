package com.organization.mvcproject.pom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * Indicates that an annotated class is a "Page Object Model" for Selenium WebDriver.
 * 
 * <p>This annotation serves as a specialization of {@link Component @Component},
 * allowing for implementation classes to be autodetected through classpath scanning.
 * It is typically used in conjunction with Selenium WebDriver to represent web pages
 * or components of web pages in an automated testing context.</p>
 * 
 * <p>Page Object Models annotated with this stereotype will be automatically
 * registered as Spring beans and can be autowired into test classes or other
 * components.</p>
 * 
 * Usage example:
 * <pre>
 * &#064;PageObjectModel("loginPage")
 * public class LoginPage {
 *     &#064;FindBy(id = "username")
 *     private WebElement usernameInput;
 *     
 *     // ... page object implementation
 * }
 * </pre>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PageObjectModel {
    
    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     * 
     * @return the suggested component name, if any (or empty String otherwise)
     */
    @AliasFor(annotation = Component.class)
    String value() default "";
    
    /**
     * Indicates the relative URL path for this page object model.
     * This can be used to navigate to the page or validate the current URL.
     * 
     * @return the relative URL path for this page
     */
    String path() default "";
    
    /**
     * Indicates the title that should be present when this page is loaded.
     * This can be used for validation purposes in your tests.
     * 
     * @return the expected page title
     */
    String title() default "";
    
    /**
     * Specifies the timeout in seconds to wait for this page to load.
     * A value of 0 indicates that the default timeout should be used.
     * 
     * @return the page load timeout in seconds
     */
    int timeoutSeconds() default 0;
}