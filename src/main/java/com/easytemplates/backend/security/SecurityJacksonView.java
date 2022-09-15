package com.easytemplates.backend.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import com.easytemplates.backend.security.SecurityConfig.SECURITY_ROLE;

@RestControllerAdvice
public class SecurityJacksonView extends AbstractMappingJacksonResponseBodyAdvice {

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType,
                                           MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {

        SecurityLogging.log("Jackson: Filtering the response...");
        
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getAuthorities() != null) {
        	
            SecurityLogging.log("Jackson: Verifying User Authorities...");
            
            Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            
            SecurityLogging.log("Jackson: Building the filtered JSON...");
            
            List<Class> jsonViews = authorities.stream()
            		.map(GrantedAuthority::getAuthority).map(SECURITY_ROLE::valueOf)
                    .map(SecurityRole.MAPPING::get)
                    .collect(Collectors.toList());
            
            if (jsonViews.size() == 1) {
                bodyContainer.setSerializationView(jsonViews.get(0));
                return;
            }
            
            throw new IllegalArgumentException("Multiple role declaration, unhandled case! Information: " + authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")));
        }
    }
}