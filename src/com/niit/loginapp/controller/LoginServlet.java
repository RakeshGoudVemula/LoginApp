package com.niit.loginapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.loginapp.dao.LoginDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		String USERID=request.getParameter("user ID");
		String password=request.getParameter("password");
		//send it to corresponding DAO
		
		
		LoginDAO loginDAO=new LoginDAO();
		
		//Get the request dispatch so that we dispatch either to home or login page
		
		if(loginDAO.isValidCredentials(USERID, password)){
			
			// navigate/dispatch to home page
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Home.html");
			dispatcher.forward(request, response); //supposed to use include  in place of forward.
			
		}
		else{
			//navigate to login page and show error msg.
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Login.html");
			PrintWriter writer = response.getWriter();
			writer.append("InValid username or password");
		 //we have to include login.html + this message.
			dispatcher.include(request, response); 

		}
		

	}



}
