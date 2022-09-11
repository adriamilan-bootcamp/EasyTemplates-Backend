package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.HEADER_AUTHORIZATION_KEY;
import static com.easytemplates.backend.security.SecurityConstants.ISSUER_INFO;
import static com.easytemplates.backend.security.SecurityConstants.SUPER_SECRET_KEY;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_BEARER_PREFIX;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_EXPIRATION_TIME;
import com.easytemplates.backend.dto.Usuarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SecurityJWTUtil extends UsernamePasswordAuthenticationFilter {

	// The AuthenticationManager Object
	private AuthenticationManager authenticationManager;

	/**
	 * 	Class constructor
	 * 	@param authenticationManager
	 */
	public SecurityJWTUtil(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			// Find the User/Password combination; assume JSON Body
			Usuarios userCreds = new ObjectMapper().readValue(request.getInputStream(), Usuarios.class);

			// Try to authenticate
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					userCreds.getEmail(), userCreds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String JWTToken = Jwts.builder()
				// Token Issuing Date
				.setIssuedAt(new Date())
				// Token Issuer (Us)
				.setIssuer(ISSUER_INFO)
				// Subject for the Token (User who requested it)
				.setSubject(((Usuarios) auth.getPrincipal()).getNombre())
				// Expiration date for the token
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				// What to sign the token with
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
				// Build and sign the token
				.compact();
		
		// Add the token to the header...
		response.addHeader(HEADER_AUTHORIZATION_KEY, TOKEN_BEARER_PREFIX + " " + JWTToken);

		// ...and response
		response.getWriter().write("Logged in succesfully!\nWelcome " + ((Usuarios) auth.getPrincipal()).getNombre() + ", your token is: " + JWTToken);
		
		// Print it on Spring
		System.out.println(response.getHeader(HEADER_AUTHORIZATION_KEY));
	
	}
	
	
	
}