package com.easytemplates.backend.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SecurityCORSFilter implements Filter {
	
	// A Simple Logger that will inform about the CORS Filter Subsystems Status
	private final Logger secCORSFltLog = LoggerFactory.getLogger(SecurityCORSFilter.class);
	
	/**
	 * 	The CORS Filter Security Class Constructor
	 */
	public SecurityCORSFilter() {
		secCORSFltLog.info("[SECURITY] CORS Filter: Initializing the CORS Filter Subsystem...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Filtered HTTP Request/Response Servlets, typecasted
	    HttpServletRequest filteredHTTPRequest = (HttpServletRequest) request;
	    HttpServletResponse filteredHTTPResponse = (HttpServletResponse) response;
	
	    // CORS-Related Header modifications
	    filteredHTTPResponse.setHeader("Access-Control-Allow-Origin", filteredHTTPRequest.getHeader("Origin"));
	    filteredHTTPResponse.setHeader("Access-Control-Allow-Credentials", "true");
	    filteredHTTPResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	    filteredHTTPResponse.setHeader("Access-Control-Max-Age", "3600");
	    filteredHTTPResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Host, Content-Lenght");
	
	    // Filter the Requests and Responses
	    chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}
	
	@Override
	public void destroy() {
	}
}
