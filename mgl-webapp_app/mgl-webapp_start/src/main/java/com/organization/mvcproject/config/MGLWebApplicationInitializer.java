package com.organization.mvcproject.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MGLWebApplicationInitializer implements WebApplicationInitializer {


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(MvcConfiguration.class);
		webContext.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(webContext));
		
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
	
}