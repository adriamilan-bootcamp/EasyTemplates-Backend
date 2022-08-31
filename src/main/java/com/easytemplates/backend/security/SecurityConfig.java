package com.easytemplates.backend.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
	
		// Filter /login URI HTTP Requests
		.addFilterBefore(new SecurityLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)

				
		// Filter all the non-login HTTP Requests
		.addFilterBefore(new SecurityJWTFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Accounts mocking
		auth.inMemoryAuthentication().withUser("admin").password("{noop}r00t").roles("admin");

		auth.inMemoryAuthentication().withUser("user").password("{noop}1337").roles("uiser");
	}
}
