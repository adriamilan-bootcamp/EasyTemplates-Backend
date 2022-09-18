package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.LOGIN_URL;
import static com.easytemplates.backend.security.SecurityConstants.REGISTER_URL;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

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
			"/v2/api-docs",
			"/configuration/ui",
			"/swagger-resources",
			"/configuration/security",
			"/swagger-ui.html",
			"/swagger-ui/**",
			"/webjars/**",
			"/swagger-resources/configuration/ui",
	        "/api/docs/**"
	};
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
        http
        .cors().configurationSource(corsConfigurationSource()).and()
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
            .addFilter(new SecurityAuthentication(authenticationManager(null)))
            .addFilter(new SecurityAuthorization(authenticationManager(null), userDetailsService))
        // Header configurations
        .headers()
        	// Protect against XSS w/the inbuilt Spring Protection
            .xssProtection()
            .and()
            // Enable CSP for a more bulletproof protection, only allow from same host
            .contentSecurityPolicy("script-src 'self'");
 
            http.authenticationProvider(authenticationProvider());
        
        return http.build();
    }
	
	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	     
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(bCryptPasswordEncoder());
	 
	    return authProvider;
	}
	
	/**
	 * 	The CORS Config. Spring Bean
	 * 	@return	The config. source
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	/**
	 *  Add Roles for the Security Class
	 */
	public enum SECURITY_ROLE {
        ROLE_USER,
        ROLE_ADMIN,
        ROLE_ANONYMOUS
    }
}