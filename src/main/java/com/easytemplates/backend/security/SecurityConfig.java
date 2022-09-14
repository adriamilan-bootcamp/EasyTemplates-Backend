package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.LOGIN_URL;
import static com.easytemplates.backend.security.SecurityConstants.REGISTER_URL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// UserDetailsService to use for auth.
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	/**
	 * 	Class Constructor
	 * 
	 * 	@param userDetailsService
	 */
	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	/**
	 * 	The password encoder Spring Bean
	 * 	@return	The Encoder itself
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private static final String[] AUTH_WHITELIST = {
	        "/api/swagger-ui/**",
	        "/api/doc.html",
	        "/swagger-ui/**",
	        "/v3/api-docs/**"
	};
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        	// TODO: Configure CSRF
        	// Disable CSRF
        	.csrf().disable()
        	// Authorize the following requests
        	.authorizeRequests()
        		// SwaggerUI / OpenAPI related endpoints
        		.antMatchers(AUTH_WHITELIST).permitAll()
        		// Default endpoint
        		.antMatchers(HttpMethod.GET, "/").permitAll()
        		// Login and Register URL
        		.antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
        		.antMatchers(HttpMethod.POST, REGISTER_URL).permitAll()
        		// All the remaining endpoints, need to be authenticated and/or authorized
        		.anyRequest().authenticated()
        	.and()
	            // Request Filters, both for Authentication and Authorization
	            .addFilter(new SecurityAuthentication(authenticationManager()))
	            .addFilter(new SecurityAuthorization(authenticationManager(), userDetailsService))
	        // Header configurations
	        .headers()
	        	// Protect against XSS w/the inbuilt Spring Protection
	            .xssProtection()
	            .and()
	            // Enable CSP for a more bulletproof protection, only allow from same host
	            .contentSecurityPolicy("script-src 'self'");
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Process the User info (Username, password...)
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	
	/**
	 * 	The CORS Config. Spring Bean
	 * 	@return	The config. source
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}