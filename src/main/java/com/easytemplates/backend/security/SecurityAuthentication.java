package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.HEADER_AUTHORIZATION_KEY;
import static com.easytemplates.backend.security.SecurityConstants.ISSUER_INFO;
import static com.easytemplates.backend.security.SecurityConstants.SUPER_SECRET_KEY;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_BEARER_PREFIX;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.util.UrlPathHelper;

import com.easytemplates.backend.dto.Usuarios;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SecurityAuthentication extends UsernamePasswordAuthenticationFilter {

	// The AuthenticationManager Object
	private AuthenticationManager authenticationManager;

	private final static UrlPathHelper urlPathHelper = new UrlPathHelper();

	/**
	 * Class constructor
	 * 
	 * @param authenticationManager
	 */
	public SecurityAuthentication(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	private Gson gson = new Gson();

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		SecurityLogging.getRequestInfo("Authentication");

		try {
			// Find the User/Password combination; assume JSON Body
			Usuarios userCreds = new ObjectMapper().readValue(request.getInputStream(), Usuarios.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCreds.getEmail(),
					userCreds.getPassword(), userCreds.getAuthorities()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String generateAccessToken(Usuarios user) {

		SecurityLogging.log("Authentication: Building JSON Web Token...");

		final String authorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		return Jwts.builder()
				// Token Issuing Date
				.setIssuedAt(new Date())
				// Token Issuer (Us)
				.setIssuer(ISSUER_INFO).claim("roles", authorities)
				// Subject for the Token (User who requested it)
				.setSubject(user.getEmail())
				// Expiration date for the token
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				// What to sign the token with
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
				// Build and sign the token
				.compact();
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		SecurityLogging.log("Authentication-Request: Failed authentication trying to access "
				+ urlPathHelper.getPathWithinApplication((HttpServletRequest) request));

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write("Wrong email/password combination!");
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String JWTToken = generateAccessToken((Usuarios) auth.getPrincipal());

		// Add the token to the header...
		response.addHeader(HEADER_AUTHORIZATION_KEY, TOKEN_BEARER_PREFIX + " " + JWTToken);

		// JSON Object
		JsonObject json = new JsonObject();

		// token keypair.
		json.addProperty("token", JWTToken);

		String userJsonString = this.gson.toJson(json);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// ...and response
		response.getWriter().write(userJsonString);

		// Print it on Spring
		SecurityLogging.log("Authentication: " + "Client has been correctly authenticated as \'"
				+ ((Usuarios) auth.getPrincipal()).getUsername() + "\'");

	}

}