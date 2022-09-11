package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.HEADER_AUTHORIZATION_KEY;
import static com.easytemplates.backend.security.SecurityConstants.SUPER_SECRET_KEY;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_BEARER_PREFIX;

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

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class SecurityJWTFilter extends BasicAuthenticationFilter {

	/**
	 * 	Class constructor
	 * 	@param authManager
	 */
	public SecurityJWTFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Get the HTTP Request's Header
		String HTTPReqtHdr = request.getHeader(HEADER_AUTHORIZATION_KEY);
		
		// Check if we have headers in the request or a token
		if (HTTPReqtHdr == null || !HTTPReqtHdr.startsWith(TOKEN_BEARER_PREFIX)) {
			// If we don't, filter out the request
			chain.doFilter(request, response);
			return;
		}
		
		// Start the authentication
		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
		
		// Handle the auth.
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Filter it based on the type
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

		// Get the HTTP Request's Header
		String JWTToken = request.getHeader(HEADER_AUTHORIZATION_KEY);
		
		// Proceed if and only if the token exists on the header
		if (JWTToken != null) {
			/**
			 * 	In order to retrieve the username (And match it w/the password to return a token) we first
			 * 	need to decipher the actual token using our secret HMAC SHA512 key
			 */
			String username = Jwts.parser()
						// Cipher key to decrypt the token
						.setSigningKey(SUPER_SECRET_KEY)
						// Parse the Bearer Token
						.parseClaimsJws(JWTToken.replace(TOKEN_BEARER_PREFIX, ""))
						// Get the body of the token...
						.getBody()
						// ...and the subject, which (If all's correct) should be the username
						.getSubject();

			// If the username exists, we can proceed to retrieve a new token for the user logon
			if (username != null) {
				return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
			}
			
			return null;
		}

		return null;
	}
}