package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step:1 Read the data
		int EmpId = Integer.parseInt(request.getParameter("EmpId"));
		String Empname = request.getParameter("Empname");
		double Basicsal = Double.parseDouble(request.getParameter("Basicsal"));
		double basicSalary = Double.parseDouble(request.getParameter("Basicsal"));
		
		//Step:2 Process the data
		double HRA = 0.0;
        double DA = 0.0;
        double PF = 0.0;
        double grossSalary = 0.0;
        
        if (basicSalary >= 50000) 
        {
            HRA = 0.3 * basicSalary;
            DA = 0.1 *  basicSalary;
            PF = 0.06 * basicSalary;
        } 
        else if (basicSalary >= 25000 && basicSalary < 50000) 
        {
            HRA = 0.2 * basicSalary;
            DA = 0.05 * basicSalary;
            PF = 0.03 * basicSalary;
        } 
        else if (basicSalary < 25000) 
        {
            HRA = 0.1 * basicSalary;
            DA = 0.03 * basicSalary;
            PF = 0.02 * basicSalary;
        }
        grossSalary = basicSalary + HRA + DA - PF;
        
		//step3:Render the response
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h2>Gross Salary Details:</h2>");
        writer.println("<p>Employee name:"+Empname+"</p>");
        writer.println("<p>Employee Id:"+EmpId+"</p>");
        writer.println("<p>Basic Salary: " + basicSalary + "</p>");
        writer.println("<p>HRA: " + HRA + "</p>");
        writer.println("<p>DA: " + DA + "</p>");
        writer.println("<p>PF: " + PF + "</p>");
        writer.println("<p>Gross Salary: " + grossSalary + "</p>");
        writer.println("</body></html>");

	}

}
