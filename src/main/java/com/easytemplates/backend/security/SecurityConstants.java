package com.easytemplates.backend.security;

public class SecurityConstants {
	
	// Spring Security
	// Login URI
	public static final String LOGIN_URL = "/login";
	// Type of auth.
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	// Bearer token, to use w/JWT
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT
	// The issuer (Ourselves)
	public static final String ISSUER_INFO = "easytemplates";
	// Simple, difficult-to-guess super secret key
	public static final String SUPER_SECRET_KEY = "3@sy.-:73m9l@735";
	// 7-day validity for the JWT
	public static final long TOKEN_EXPIRATION_TIME = 604_800_000;
}
