package com.wisely.ch7_6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/*
	 * @Bean public ViewResolver viewResolver() { InternalResourceViewResolver
	 * viewResolver = new InternalResourceViewResolver();
	 * viewResolver.setPrefix("/templates/"); viewResolver.setSuffix(".html");
	 * return viewResolver; }
	 */
	
	/*
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addViewController("/ws").setViewName("ws");
	 * registry.addViewController("/login").setViewName("login");
	 * registry.addViewController("/chat").setViewName("chat"); }
	 */
	
	public void addViewControllers(ViewControllerRegistry registry) { 
		registry.addViewController("/home").setViewName("home"); 
		registry.addViewController("/").setViewName("home"); 
		registry.addViewController("/hello").setViewName("hello");
//		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/ws").setViewName("ws");
		registry.addViewController("/login").setViewName("prelogin"); 
		registry.addViewController("/chat").setViewName("chat");
	}


}
