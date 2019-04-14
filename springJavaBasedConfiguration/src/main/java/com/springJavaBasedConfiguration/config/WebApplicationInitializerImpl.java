package com.springJavaBasedConfiguration.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebApplicationInitializerImpl implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
		container.register(StartUp.class);
		Dynamic servlet = servletContext.addServlet("ds", new DispatcherServlet(container));
		servlet.setLoadOnStartup(3);
		servlet.addMapping("/");

	}

}
