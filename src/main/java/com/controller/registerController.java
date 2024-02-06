package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.CommonDao;
import com.Model.userS;

@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   
    public registerController() {
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		long mobNumber=Long.parseLong(request.getParameter("mobNumber")) ;
		String password=request.getParameter("password");
		userS u = new userS(username, email, mobNumber, password);
		CommonDao cd = new CommonDao();
		int i = cd.register(u);
		if(i>0) {
			System.out.println("User registered");
			response.sendRedirect("HomeView.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
