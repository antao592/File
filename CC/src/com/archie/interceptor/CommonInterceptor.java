package com.archie.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        
        String username = (String) request.getSession().getAttribute("username");
        //������Ը���session���û����жϽ�ɫ��Ȩ�ޣ�����Ȩ�����ض���ͬ��ҳ�棬�����������ֻ������һ���ض���
        if (username == null) {
            //�����أ��ض���login����
        	response.sendRedirect(request.getContextPath() + "/login.jsp"); 
            return false;
        }
        return true;
	}
}
