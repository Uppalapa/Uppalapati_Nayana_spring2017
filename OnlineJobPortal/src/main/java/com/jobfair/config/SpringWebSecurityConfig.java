package com.jobfair.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http
		    .authorizeRequests()
		        .antMatchers("/login","/resources/**", "/register","/logout").permitAll()
		        .antMatchers("/home").hasAnyRole("EMPLOYER" ,"JOBSEEKER","ADMIN" )
		        .antMatchers("/emp","/emp/**").hasRole("EMPLOYER")
		        .antMatchers("/jobSeeker","/jobSeeker/**").hasRole("JOBSEEKER")
		        .antMatchers("/admin","/admin/**").hasRole("ADMIN")
		        .and()
		    .formLogin()
		        .loginPage("/login")
		        .loginProcessingUrl("/login")
		        .failureUrl("/login?error")
		        .defaultSuccessUrl("/home")
		        .and()
			.logout().logoutSuccessUrl("/login?logout"); 

		
	}

}
