package com.examples.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Enumeration;

//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Hello World Servlet
 */
public class HelloWorldServlet extends HttpServlet {
	
	/* 
	 * Called when getting loaded into web container
	 * We can specify the initialization logic here.
	 */
	public void init()
	{
		System.out.println("HelloWorld Servlet Initialized...");
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	
	/*
	 * Called for every HTTP request
	 */
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		// http://localhost:8080/hello-world-servlet
		System.out.println("Context Path : " + request.getContextPath());
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements())
		{
			String headerName = headerNames.nextElement();
			System.out.println(headerName + ":" + request.getHeader(headerName));
		}
		
		response.setContentType("text/html");
		// Auto refresh every 5 secs
		// response.setIntHeader("refresh", 5);
				
		System.out.println("Servlet service method invoked...");
		// Output stream to write data into HTTP response
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.println("<h1>Hello World Servlet</h1>");
		out.println("<h2>Current Date: " + LocalDateTime.now()+"</h2>");
		out.println("</body></html>");
	}
	
	/* 
	 * Called when getting unloaded from web container
	 * We can specify the clean up logic here.
	 */	
	public void destroy()
	{
		System.out.println("HelloWorld Servlet Destroyed...");		
	}

}
