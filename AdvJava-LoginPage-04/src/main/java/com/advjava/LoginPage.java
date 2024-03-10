package com.advjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	if(userName.equalsIgnoreCase("mahesh") && password.equals("Mahesh12@"))
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("success.html");
		dispatcher.forward(request, response);
	}
	else
	{
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Login Fail ... Try with valid data");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
		dispatcher.include(request, response);
	}
	}

}
