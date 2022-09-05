package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.LOGIN_URL;
import static com.easytemplates.backend.security.SecurityConstants.REGISTER_URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// UserDetailsService to use for auth.
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
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        	// Disable *both* CSRF and CORS
        	// TODO: Is CORS *really active* then?
        	.cors().and()
        	.csrf().disable()

        	.authorizeRequests()
        		.antMatchers(HttpMethod.GET, "/").permitAll()
        		.antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
        		.antMatchers(HttpMethod.POST, REGISTER_URL).permitAll()
        		.anyRequest().authenticated()
        		// Permit POST Method in /login URI (No auth. needed)
        	
        	.and()
	            // Request Filters
	            .addFilter(new SecurityJWTUtil(authenticationManager()))
	            .addFilter(new SecurityJWTFilter(authenticationManager()));
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