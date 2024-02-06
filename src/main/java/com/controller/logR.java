package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CommonDao;
import com.Model.Login;


@WebServlet("/logR")
public class logR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public logR() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommonDao  cd = new CommonDao();
		
		List<Login> ul = new ArrayList<Login>();
				ul = cd.userlist();
		
		if(ul!=null){
			HttpSession session = request.getSession();
			session.setAttribute("userlist", ul);
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
