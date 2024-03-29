package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step:1 Read the required data
		int first = Integer.parseInt(request.getParameter("first"));
		int Second = Integer.parseInt(request.getParameter("Second"));
		String Operation = request.getParameter("Operation");
		
		//step:2 Process the data
		int result = 0;
		switch(Operation)
		{
		case "+" :result = first + Second;
				break;
				
		case "-" :result = first - Second;
		break;
		
		case "*" :result = first * Second;
		break;
		
		case "/" :result = first / Second;
		break;
		
		case "%" :result = first % Second;
		break;
		}
		
		//step3:Render the response
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>Your Result</h1>");
		writer.println("<p>Your First Number:"+first+"</p>");
		writer.println("<p>Your Second Number:"+Second+"</p>");
		writer.println("<p>Your Operation Symbol:"+Operation+"</p>");
		writer.println("<p>Your Result:"+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
