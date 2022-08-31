package com.easytemplates.backend.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import io.jsonwebtoken.Jwts;

import static com.easytemplates.backend.security.SecurityConstants.HEADER_AUTHORIZATION_KEY;
import static com.easytemplates.backend.security.SecurityConstants.SUPER_SECRET_KEY;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_BEARER_PREFIX;

public class SecurityJWTFilter extends BasicAuthenticationFilter {

	/**
	 * 	The Constructor of the class
	 * 
	 * 	@param authManager	The AuthenticationManager object to use in the inherited superclass
	 */
	public SecurityJWTFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// String containing the HTTP Request's Header
		String HTTPRequestHeader = request.getHeader(HEADER_AUTHORIZATION_KEY);
		
		// Check if we're dealing w/a request that contains or not a JWT Bearer Authentification object in the body
		if (HTTPRequestHeader == null || !HTTPRequestHeader.startsWith(TOKEN_BEARER_PREFIX)) {
			// If we don't, don't process the request and leave as-is
			chain.doFilter(request, response);
			return;
		} else {
			/**
			 *	Now that we confirmed we're dealing w/a JWT-driven auth-ed request, proceed to process the req. 
			 */
			
			// User/pass authentication is now Database-driven w/user-pass interactions
			UsernamePasswordAuthenticationToken authentication = SecurityJWTUtil.getAuthentication(request);
			
			// Setup a new SecurityContext w/that authentication information
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			// Apply the request filtering
			chain.doFilter(request, response);	
		}
	}
}