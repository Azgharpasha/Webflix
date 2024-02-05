package com.MovieMania.Wishlist.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;

import java.io.IOException;

/**
 * Indicates this as a configuration class
 */

public class FilterConfig extends GenericFilter {
    /*
     *  Create a bean for FilterRegistrationBean.
     *  1. Register the JwtFilter For Both User And Admin Role
     *  2. add URL pattern for all requests so that any request for
     *     that URL pattern will be intercepted by the filter
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Request-Headers","");
        response.setHeader("Access-Control-Allow-Headers", "*");
        if(request.getMethod().equals(HttpMethod.OPTIONS.name())){
            filterChain.doFilter(request,response);
        }
        else{
            String authHeader = request.getHeader("Authorization");
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                throw new ServletException("Missing or Invalid JWT TOken");
            }
            String token = authHeader.substring(7);
            System.out.println(token);
        }
        filterChain.doFilter(request,response);

    }


//    @Bean
//    public FilterRegistrationBean jwtUserFilter() {
//
//        FilterRegistrationBean filter = new FilterRegistrationBean();
//        filter.setFilter(new JWTFilter());
//
//        filter.addUrlPatterns("/api/v3/*");
//
//        return filter;
//
//    }
}