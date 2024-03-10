package com.advjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		String prodName = request.getParameter("prodName");
		double prodPrice = Double.parseDouble(request.getParameter("prodPrice"));
		int prodQuantity = Integer.parseInt(request.getParameter("prodQuantity"));
		
		double totalBill ;
		totalBill = prodPrice * prodQuantity ;
		String discountMessage = "No Discount";
		double discount = 0.0;
		if(totalBill > 1000 && totalBill < 5000)
		{
			discount = totalBill * 0.05;
			discountMessage = " 5% Discount"; 
		}
		else if(totalBill >= 5000 && totalBill < 10000)
		{
			discount = totalBill * 0.10;
			discountMessage = " 10% Discount"; 
		}
		else if(totalBill >= 10000)
		{
			discount = totalBill * 0.15;
			discountMessage = " 15% Discount"; 
		}
		double finalBill = totalBill - discount;
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><body bgcolor='aqua'>");
		printWriter.println("<h1> ***** PRODUCT INVOICE *****</h1>");
		printWriter.println("<p>YOUR PRODUCT ID : "+prodId+"</p>");
		printWriter.println("<p>YOUR PRODUCT NAME : "+prodName+"</p>");
		printWriter.println("<p>YOUR PRODUCT PRICE : "+prodPrice+"</p>");
		printWriter.println("<p>TOTAL PRICE OF  : "+prodQuantity+" PRODUCTS : $"+totalBill);
		printWriter.println(discountMessage+" AMOUNT : "+discount);
		printWriter.println("<p>NET AMOUNT TO PAY  : $"+finalBill+"</p>");
		printWriter.println("</body></html>");

	}

}
