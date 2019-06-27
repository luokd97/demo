package com.example.demo.filter;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Order(1)
//重点
@WebFilter(filterName = "testFilter1", urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        HttpSession session = httpServletRequest.getSession();
        System.out.println(httpServletRequest.getRequestURI());
        if(!httpServletRequest.getRequestURI().equals("/login")&&!httpServletRequest.getRequestURI().equals("/loginApi")&&session.getAttribute("user")==null){
            httpServletResponse.sendRedirect("login");
            System.out.println("_()()(()(__)()(_()_(_)()");
        }

        filterChain.doFilter(servletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
