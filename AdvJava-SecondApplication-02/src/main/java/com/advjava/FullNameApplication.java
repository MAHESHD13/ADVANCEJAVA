package com.advjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FullNameApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String fullName;
		fullName = firstName + lastName;
		response.setContentType("text/plain");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Your FullName..."+fullName);
		
	}

}
