package com.easytemplates.backend.security;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SecurityLogging {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityLogging.class);
    
	private static final String[] IP_HEADER_CANDIDATES = {
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

		public static void log(String msg) {
			LOG.info("[SECURITY] " + msg);
		}
		
		public static void logMsg(String from, String msg) {
			LOG.info("[" + from + "] " + msg);
		}
	
	    public static void getRequestInfo(String fromModule) {

	    	if (RequestContextHolder.getRequestAttributes() == null) {
				log(fromModule + "-Request: Invalid (Client is 0.0.0.0 ?)");
	        }
	    	
	    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

	        for (String headerList: IP_HEADER_CANDIDATES) {
	            String ipDict = request.getHeader(headerList);
	            if (ipDict != null && ipDict.length() != 0 && !"unknown".equalsIgnoreCase(ipDict)) {
	                String match = ipDict.split(",")[0];
	                log(fromModule + "-Request: Got request from " + match);
	            }
	        }

	        log(fromModule + "-Request: New request, processing...");
	        log(fromModule + "-Request: From  " + request.getRemoteAddr());
	        
	        if (request.getQueryString() != null)
	        	log(fromModule + "-Request: Query " + request.getQueryString());
	        
	        log(fromModule + "-Request: To    " + request.getRequestURL().toString());
	    }
}
