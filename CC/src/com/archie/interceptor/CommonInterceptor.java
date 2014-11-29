package com.archie.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        
        String username = (String) request.getSession().getAttribute("username");
        //这里可以根据session的用户来判断角色的权限，根据权限来重定向不同的页面，简单起见，这里只是做了一个重定向
        if (username == null) {
            //被拦截，重定向到login界面
        	response.sendRedirect(request.getContextPath() + "/login.jsp"); 
            return false;
        }
        return true;
	}
}
