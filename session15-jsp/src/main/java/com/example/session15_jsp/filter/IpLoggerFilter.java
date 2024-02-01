package com.example.session15_jsp.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.*;
import java.io.IOException;

public class IpLoggerFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(IpLoggerFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ipAddress = servletRequest.getRemoteAddr();
        filterChain.doFilter(servletRequest,servletResponse);
        logger.warn(String.format("Request from IP address: %s" , ipAddress));
    }
}
