package com.capgemini.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= "/getNews", loadOnStartup = 1)
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		String path = request.getParameter("paper");
        
		if(path.equals("TOI")) {
			response.sendRedirect("https://timesofindia.indiatimes.com/");
		}
		else if(path.equals("EconomicTimes")) {
			response.sendRedirect("https://economictimes.indiatimes.com/");
		}
		else if(path.equals("MaharashtraTimes")) {
			response.sendRedirect("https://maharashtratimes.indiatimes.com/");
		}
		else if(path.equals("DNAIndia")) {
			response.sendRedirect("https://www.dnaindia.com/");
		}
	}

}
