package com.easytemplates.backend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class SecurityJWTFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Grab the authentication information from the HTTP Request
		Authentication authentication = SecurityJWTUtil.getAuthentication((HttpServletRequest) request);

		// Setup a new SecurityContext w/that authentication information
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Apply the request filtering
		chain.doFilter(request, response);
	}

}
