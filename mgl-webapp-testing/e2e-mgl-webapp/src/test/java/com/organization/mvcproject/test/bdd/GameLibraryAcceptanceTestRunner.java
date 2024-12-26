package com.organization.mvcproject.test.bdd;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/organization/mvcproject/test/bdd")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, 
	value ="com.organization.mvcproject.test.bdd,"
	    +  "com.organization.mvcproject.test.bdd.glue")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
/*
 * WARNING: Discovering tests using the cucumber.features property. Other discovery selectors are ignored!
   This is a work around for the limited JUnit 5 support in Maven and Gradle. Please request/upvote/sponsor/ect better support for JUnit 5 discovery selectors. For details see: https://github.com/cucumber/cucumber-jvm/pull/2498
 If you are using the JUnit 5 Suite Engine, Platform Launcher API or Console Launcher you should not use this property. Please consult the JUnit 5 documentation on test selection.
 @ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:com/organization/mvcproject/test/bdd")
 */
public class GameLibraryAcceptanceTestRunner {

}
