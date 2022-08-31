package com.easytemplates.backend.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

import static com.easytemplates.backend.security.SecurityConstants.TOKEN_BEARER_PREFIX;
import static com.easytemplates.backend.security.SecurityConstants.HEADER_AUTHORIZATION_KEY;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_EXPIRATION_TIME;
import static com.easytemplates.backend.security.SecurityConstants.SUPER_SECRET_KEY;
import static com.easytemplates.backend.security.SecurityConstants.ISSUER_INFO;

public class SecurityJWTUtil {

	/**
	 * 	This functions's purpose is to generate a JSON Web Token based-off the username
	 * 	String that gets passed as a parameter w/some attributes; store it and enable it
	 * 	as an active Bearer Authentication key.
	 * 
	 * 	@param res		The response to send to the client containing the JWT
	 * 	@param username	The username to generate the JWT for
	 */
    static void addAuthentication(HttpServletResponse response, String username) {
    	
    	// Create a new JWT using jjwt-api
    	// DOCUMENTATION: https://github.com/jwtk/jjwt#jws-create
        String jwtString = Jwts.builder()
        	
        	// Who issues the token
        	.setIssuer(ISSUER_INFO)
        	
        	// Who's the token subject
            .setSubject(username)

            // Attatch the issue date to the token (At time of call)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            
            // Add the expiration date of the token
            .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))

            // Tokens are signed w/a secret key using HMAC SHA-512
            .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
            
            // Build and sign the token
            .compact();

        // Add the newly generated token to the HTTP Response and send it back to the client
        response.addHeader(HEADER_AUTHORIZATION_KEY, TOKEN_BEARER_PREFIX + jwtString);
    }

}
