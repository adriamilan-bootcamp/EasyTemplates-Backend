package com.easytemplates.backend.security;

public class SecurityConstants {

	/**
	 *  Spring Security
	 *  
	 *  Set of constants that aid in Spring Security definitions
	 */
	
	// Login URI
	public static final String LOGIN_URL = "/login";
	
	// Register URI
	public static final String REGISTER_URL = "/register";
	
	// HTTP Request Header value that holds the auth. type
	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
	
	// Bearer-type auth. (Tokenized)
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	/**
	 *  JSON Web Token (jjwt-api)
	 *  
	 *  Set of constants that aid in JWT handling
	 */
	
	// Who's the token issuer (Us)
	public static final String ISSUER_INFO = System.getenv("ISSUER_INFO");
	
	/**
	 * 	The Super Secret Key™ that is capable of (de)ciphering the JSON Web Token
	 * 	in exchange for the *actual* contents of the object.
	 * 
	 *	It *needs* too be lengthier than 16-chars and combine alphanumeric values
	 *	(For characters, both upper and lowercase) w/symbols in order to guarantee
	 *	a secure, non-bruteforceable keypair.
	 *
	 *	We'll default to HMAC SHA512 for our cryptographical needs, which is more than
	 *	enough considering the tyoe of project we're dealing with.
	 */
	public static final String SUPER_SECRET_KEY = System.getenv("SUPER_SECRET_KEY");
	
	// The token expiration time, set it to 1 week by default unless changed
	public static final long TOKEN_EXPIRATION_TIME = 604_800_000;
	
}
