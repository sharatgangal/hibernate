package com.stackroute.customer.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ApplicationContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {WebMvcConfig.class};
	}

	@Override
	// http://localhost:8080/customermanagementhibernate
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
		
		}
	}


