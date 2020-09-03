package com.stackroute.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
//@Configuration indicates that the class can be
//used by the Spring IOC container as a source of
//bean definitions
@ComponentScan("com.stackroute.customer")
// this annotation is used to search for the Spring
// components amongst the application classes
@EnableWebMvc
// Adding this annotation to an @Configuration class imports
// Spring MVC configuration from WebMvcConfigurationSupport
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver view=new InternalResourceViewResolver();
	    view.setPrefix("/WEB-INF/views/");
	    view.setSuffix(".jsp");
	    return view;
	}

}
