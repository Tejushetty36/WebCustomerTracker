package com.springdemo.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = "springstudent";
		String password = "springstudent";
		
		String jdbcurl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String jdbcdriver = "com.mysql.cj.jdbc.Driver";
		
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: "+jdbcurl);
			
			Class.forName(jdbcdriver);
			
			Connection myconn = DriverManager.getConnection(jdbcurl, username, password);
			
			out.println("SUCESS!!!");
			
			myconn.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}
