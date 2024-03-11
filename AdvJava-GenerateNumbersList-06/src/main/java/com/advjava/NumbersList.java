package com.advjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NumbersList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    ArrayList<Integer> number = new ArrayList<Integer>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int startNumber = Integer.parseInt(request.getParameter("startNumber"));
		int endNumber = Integer.parseInt(request.getParameter("endNumber"));
		
		String operator = request.getParameter("number");
		switch(operator)
		{
			case "even" :
				for(int i=startNumber;i<=endNumber;i++)
				{
					if(i % 2 == 0)
					{
						number.add(i);
					}
				}
				break;
			case "odd" :
				for(int i=startNumber;i<=endNumber;i++)
				{
					if(i % 2 != 0)
					{
						number.add(i);
					}
				}
				break;
			case "prime" :
				for(int i=startNumber;i<=endNumber;i++)
				{
					int flag=0;
					for(int j=2;j<i;j++)
					{
						if(i % j == 0)
						{
							flag=1;
							break;
						}
					}
					if(flag==0 && i != 1)
					{
						number.add(i);
					}
				}
				break;
		case "perfect":
			
			for(int i=startNumber;i<endNumber;i++)
			{
				int sum=0;
				for(int j=1;j<i;j++)
				{
					if(i % j == 0)
					{
						sum = sum + j;
					}
				}
				if(sum == i)
				{
					number.add(i);
				}
			}
			break;
		case "strong" :
			for(int i=startNumber;i<=endNumber;i++)
			{
				int val = i;
				int sum=0;
				while(val!=0)
				{
					int digit=val%10;
					int mul=1;
					for(int j=1;j<=digit;j++)
					{
						mul *= j;
					}
					sum += mul;
					val /= 10;
				}
				
				if(sum == i)
				{
					number.add(i);
				}
			}
			break;
		case "armstrong" :
			for(int i=startNumber;i<=endNumber;i++)
			{
				int temp1=i,temp2=i;
				int sum=0,count=0;
				while(temp1 != 0)
				{
					temp1 = temp1 / 10;
					count++;
				}
				while(temp2 != 0)
				{
					int digit = temp2 % 10;
					sum = sum +(int)Math.pow(digit, count);
					temp2 = temp2 / 10;
				}
				if(sum == i)
				{
					number.add(i);
				}
			}
			break;
		}
		
		//render the data to webbrowser
		response.setContentType("text/html");
		PrintWriter writer =response.getWriter();
		RequestDispatcher dispatcher=request.getRequestDispatcher("numbers.html");
		dispatcher.include(request, response);
		writer.println("Your "+operator+"number result..."+number);
		number.clear();
	}

	
	

}
