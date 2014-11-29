package com.archie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping("/login.do")
	public void loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("admin") && password.equals("admin"))
		{
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("jsp/file_upload.jsp").forward(request, response); 
		}
		else
		{
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
	}
}
