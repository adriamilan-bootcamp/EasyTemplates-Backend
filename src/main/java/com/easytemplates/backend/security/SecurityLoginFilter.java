package com.easytemplates.backend.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityLoginFilter extends AbstractAuthenticationProcessingFilter {
	
	/**
	 * 	Constructor for the Filter; we use super() w/our URL arg. to setup a cascading
	 * 	parent object and we them set the authManager
	 * 
	 * 	@param url			The URL to process
	 * 	@param authManager	The authentication manager obj.
	 */
	public SecurityLoginFilter(String url, AuthenticationManager authManager) {
		
		// Call to the parent class
        super(new AntPathRequestMatcher(url));
        
        // Set the authManager obj.
        setAuthenticationManager(authManager);
    }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}
}
