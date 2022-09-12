package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.HEADER_AUTHORIZATION_KEY;
import static com.easytemplates.backend.security.SecurityConstants.SUPER_SECRET_KEY;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_BEARER_PREFIX;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class SecurityJWTFilter extends BasicAuthenticationFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * 	Class constructor
	 * 	@param authManager
	 */
	public SecurityJWTFilter(AuthenticationManager authManager, UserDetailsService userDetailsService) {
		super(authManager);
		this.userDetailsService = userDetailsService;
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
		
		String username = Jwts.parser()
				// Cipher key to decrypt the token
				.setSigningKey(SUPER_SECRET_KEY)
				// Parse the Bearer Token
				.parseClaimsJws(HTTPReqtHdr.replace(TOKEN_BEARER_PREFIX, ""))
				// Get the body of the token...
				.getBody()
				// ...and the subject, which (If all's correct) should be the username
				.getSubject();

		username += "@easytemplates.com";

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(HTTPReqtHdr.replace(TOKEN_BEARER_PREFIX, ""), SecurityContextHolder.getContext().getAuthentication(), userDetails);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        logger.info("authenticated user " + username + ", setting security context");
        SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Filter it based on the type
		chain.doFilter(request, response);
	}
	
	UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication authentication, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(SUPER_SECRET_KEY);

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("roles").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }
}