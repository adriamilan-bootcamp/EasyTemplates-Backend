package com.easytemplates.backend.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		// Extract the HTTP Request's body
        InputStream requestBody = request.getInputStream();

        // Map the request's JSON user and password
        User user = new ObjectMapper().readValue(requestBody, User.class);

        // Do the authentication
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getName(),
                        user.getPassword(),
                        Collections.emptyList()
                )
        );
	}
	
	@Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        // Add the JWT into the response
        SecurityJWTUtil.addAuthentication(res, auth.getName());
    }
}
