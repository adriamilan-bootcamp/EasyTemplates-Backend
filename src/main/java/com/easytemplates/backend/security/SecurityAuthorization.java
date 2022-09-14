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
import javax.servlet.http.HttpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.easytemplates.backend.dto.Usuarios;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class SecurityAuthorization extends BasicAuthenticationFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	private static final Logger LOG = LoggerFactory.getLogger(SecurityAuthorization.class);
	
	/**
	 * 	Class constructor
	 * 	@param authManager
	 */
	public SecurityAuthorization(AuthenticationManager authManager, UserDetailsService userDetailsService) {
		super(authManager);
		this.userDetailsService = userDetailsService;
	}

	private static final String[] HEADER_DICTIONARY = {
	        "X-Forwarded-For",
	        "Proxy-Client-IP",
	        "WL-Proxy-Client-IP",
	        "HTTP_X_FORWARDED_FOR",
	        "HTTP_X_FORWARDED",
	        "HTTP_X_CLUSTER_CLIENT_IP",
	        "HTTP_CLIENT_IP",
	        "HTTP_FORWARDED_FOR",
	        "HTTP_FORWARDED",
	        "HTTP_VIA",
	        "REMOTE_ADDR"
	    };
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if (RequestContextHolder.getRequestAttributes() == null) {
			LOG.info("[SECURITY] Request: Invalid (Client is 0.0.0.0 ?)");
        }

        for (String headerList: HEADER_DICTIONARY) {
            String ipDict = request.getHeader(headerList);
            if (ipDict != null && ipDict.length() != 0 && !"unknown".equalsIgnoreCase(ipDict)) {
                String match = ipDict.split(",")[0];
                LOG.info("[SECURITY] Request: Got request from " + match);
            }
        }

        LOG.info("[SECURITY] Request: New request, processing...");
        LOG.info("[SECURITY] Request: From  " + request.getRemoteAddr());
        
        if (request.getQueryString() != null)
        	LOG.info("[SECURITY] Request: Query " + request.getQueryString());
        
        LOG.info("[SECURITY] Request: To    " + request.getRequestURL().toString());
        
		LOG.info("[SECURITY] Authorization: Checking client's request access privileges...");
		
		// Get the HTTP Request's Header
		String HTTPReqtHdr = request.getHeader(HEADER_AUTHORIZATION_KEY);
		
		// Check if we have headers in the request or a token
		if (HTTPReqtHdr == null || !HTTPReqtHdr.startsWith(TOKEN_BEARER_PREFIX)) {
			// If we don't, filter out the request
			chain.doFilter(request, response);
			return;
		}
		
		LOG.info("[SECURITY] Authorization: Parsing JSON Web Token...");
		
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
		
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(HTTPReqtHdr.replace(TOKEN_BEARER_PREFIX, ""), SecurityContextHolder.getContext().getAuthentication(), userDetails);
        
		LOG.info("[SECURITY] Authorization: Matching client's roles against target...");
		
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        
        LOG.info("[SECURITY] Authorization: \'" + ((Usuarios) userDetails).getNombre() + "\' is authorized! Continuing...");
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Filter it based on the type
		chain.doFilter(request, response);
	}
	
	UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication authentication, final UserDetails userDetails) {

		LOG.info("[SECURITY] Authorization: Obtaining the roles...");
		
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