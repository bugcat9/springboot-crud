package com.zhouning.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhouning
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter 被调用");
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
