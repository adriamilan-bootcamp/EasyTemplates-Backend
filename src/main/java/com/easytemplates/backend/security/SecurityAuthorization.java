package com.easytemplates.backend.security;

import static com.easytemplates.backend.security.SecurityConstants.HEADER_AUTHORIZATION_KEY;
import static com.easytemplates.backend.security.SecurityConstants.SUPER_SECRET_KEY;
import static com.easytemplates.backend.security.SecurityConstants.TOKEN_BEARER_PREFIX;

import java.io.IOException;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.easytemplates.backend.dto.Usuarios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class SecurityAuthorization extends BasicAuthenticationFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * 	Class constructor
	 * 	@param authManager
	 */
	public SecurityAuthorization(AuthenticationManager authManager, UserDetailsService userDetailsService) {
		super(authManager);
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		SecurityLogging.getRequestInfo("Authorization");
		
		// Get the HTTP Request's Header
		String HTTPReqtHdr = request.getHeader(HEADER_AUTHORIZATION_KEY);
		
		// Check if we have headers in the request or a token
		if (HTTPReqtHdr == null || !HTTPReqtHdr.startsWith(TOKEN_BEARER_PREFIX)) {
			// If we don't, filter out the request
			chain.doFilter(request, response);
			return;
		}
		
		SecurityLogging.log("Authorization: Parsing JSON Web Token...");
		
		String username = Jwts.parser()
				// Cipher key to decrypt the token
				.setSigningKey(SUPER_SECRET_KEY)
				// Parse the Bearer Token
				.parseClaimsJws(HTTPReqtHdr.replace(TOKEN_BEARER_PREFIX, ""))
				// Get the body of the token...
				.getBody()
				// ...and the subject, which (If all's correct) should be the username
				.getSubject();


		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		
		if (userDetails == null) {
			SecurityLogging.log("Authorization: Fatal, user not found while authorizating... (userDetails == null)");
		    chain.doFilter(request, response);
		    return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(HTTPReqtHdr.replace(TOKEN_BEARER_PREFIX, ""), userDetails);
        
		if (authentication == null) {
			SecurityLogging.log("Authorization: Fatal, authentication == null while authorizating...");
		    chain.doFilter(request, response);
		    return;
		}
		
		int status = ((HttpServletResponse) response).getStatus();
		
		// Client errors (400–499)
		if (status >= 400 && status < 500) {
			SecurityLogging.log("Authorization: Fatal, request error! Status: " + status);
		    chain.doFilter(request, response);
		    return;
		}
		
		SecurityLogging.log("Authorization: Matching client's roles against target...");
		
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        
        SecurityLogging.log("Authorization: \'" + ((Usuarios) userDetails).getUsername() + "\' is authorized! Continuing...");
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Filter it based on the type
		chain.doFilter(request, response);
	}
	
	UsernamePasswordAuthenticationToken getAuthentication(final String token, final UserDetails userDetails) {

		SecurityLogging.log("Authorization: Obtaining the roles...");
		
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