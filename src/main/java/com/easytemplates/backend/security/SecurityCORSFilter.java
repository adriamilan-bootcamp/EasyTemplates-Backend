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

	// Class logger
	private final Logger secCORSLog = LoggerFactory.getLogger(SecurityCORSFilter.class);

	/**
	 *  Class constructor
	 */
	public SecurityCORSFilter() {
		// Simple log (Information regarding the state of the class)
		secCORSLog.info("[SECURITY] CORS Filter: Initializing...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// HTTP Petitions to handle (Request/Response)
		HttpServletRequest HTTPRequest = (HttpServletRequest) request;
		HttpServletResponse HTTPResponse = (HttpServletResponse) response;

		// Adapt the headers to our filtering needs
		HTTPResponse.setHeader("Access-Control-Allow-Origin", HTTPRequest.getHeader("Origin"));
		HTTPResponse.setHeader("Access-Control-Allow-Credentials", "true");
		HTTPResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		HTTPResponse.setHeader("Access-Control-Max-Age", "3600");
		HTTPResponse.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me, Host, Content-Lenght");

		// Filter by those rules
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}

}