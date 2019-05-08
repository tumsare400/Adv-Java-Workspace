package com.capgemini.bankApp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloWorld", loadOnStartup = 1, urlPatterns = { "/hello", "/helloWorld", "/login" })
public class HelloWorldController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloWorldController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		System.out.println("Hello World"); // prints on server console

		PrintWriter out = response.getWriter();
		out.println("Hello World"); // add into response

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// get credentials
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;

		if (username.equals("root") && password.equals("root@123")) {
			//out.println("<h2>Login Successful. Welcome" + username + "</h2>");
		dispatcher = request.getRequestDispatcher("success.html");
			
		} else {
			//out.println("<h2>Invalid username or password</h2>");
			dispatcher = request.getRequestDispatcher("error.html");
		}
		dispatcher.forward(request, response);
	}
}
