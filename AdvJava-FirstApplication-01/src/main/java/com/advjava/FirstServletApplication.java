package com.advjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServletApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");

		PrintWriter writer=response.getWriter();
		writer.println("This is First Servlet...");
		writer.println("Adv Java Class by Ratan Sir...");
		writer.println("Servlets Applications Very Good...");
		writer.println("Ganesh Having Dummy Laptop...");
	}




}
