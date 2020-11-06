package com.offcn.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //判断用户是否登录
        if (req.getSession().getAttribute("user")==null) {
            //没有登录则跳转到登录页面
            req.setAttribute("msg","请登录");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }else{
            //放行请求
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {

    }
}
