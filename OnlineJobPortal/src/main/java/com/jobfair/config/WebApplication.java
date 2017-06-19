package com.jobfair.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.jobfair.*" })
@EnableJpaRepositories({"com.jobfair.*"})
@EntityScan("com.jobfair.*")
public class WebApplication extends SpringBootServletInitializer  {
	
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(WebApplication.class);

	}	
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }


}
