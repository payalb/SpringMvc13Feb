package com.java.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

@WebFilter("/*")
public class CustomFilter implements Filter {
 
    private static Logger LOGGER =Logger.getLogger(CustomFilter.class);
 
    @Override
    public void init(FilterConfig config) throws ServletException {
        // initialize something
    }
 
    @Override
    public void doFilter(
      ServletRequest request, ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        LOGGER.info("Request Info : " + req);
        chain.doFilter(request, response);
    }
 
    @Override
    public void destroy() {
        // cleanup code, if necessary
    }
}