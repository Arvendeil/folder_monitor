package com.epam.nulp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ServleT extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
    private ServletConfig configuration;

    public void init(ServletConfig configuration) {
	this.configuration = configuration;
	ThreadRunner runner = new ThreadRunner();
	Thread thread = new Thread(runner);
	thread.start();
    }

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher dispatcher = request
		.getRequestDispatcher("Books.jsp");
	dispatcher.forward(request, response);
    }

}
