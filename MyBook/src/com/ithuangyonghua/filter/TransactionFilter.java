package com.ithuangyonghua.filter;

import com.ithuangyonghua.utils.DBUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            filterChain.doFilter(servletRequest,servletResponse);
            DBUtils.commitAndCloseConnection();
        }catch (Exception e){
            DBUtils.rollbackAndCloseConnection();
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    @Override
    public void destroy() {

    }
}
