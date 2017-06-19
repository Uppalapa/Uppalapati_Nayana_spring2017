package com.jobfair.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		super.addViewControllers(registry);

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		super.addResourceHandlers(registry);

		registry.addResourceHandler("message.properties");

	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		// Define all possible view resolvers
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		resolvers.add(resourceBundleViewResolver());
		resolvers.add(velocityViewResolver());

		resolver.setViewResolvers(resolvers);
		return resolver;
	}
	

	@Bean
	public ViewResolver resourceBundleViewResolver() {

		ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
		viewResolver.setBasename("views");
		viewResolver.setOrder(1);
		
		return viewResolver;
	}
	
	
	
	@Bean
	public ViewResolver velocityViewResolver() {

		VelocityViewResolver viewResolver = new VelocityViewResolver();
		
		viewResolver.setPrefix( "" );
		viewResolver.setSuffix( ".vm" );
		
		return viewResolver;
	}
}
