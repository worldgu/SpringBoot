package com.zero.proficientspringboot.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/19 21:08
 * @modified By：
 */
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest request = (HttpServletRequest) srequest;
        System.out.println("this is MyFilter2,url :" + request.getRequestURI());
        chain.doFilter(srequest,sresponse);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
