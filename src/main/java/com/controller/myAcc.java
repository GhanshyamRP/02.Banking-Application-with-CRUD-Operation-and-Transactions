package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Model.userS;

@WebServlet("/myAcc")
public class myAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public myAcc() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		UserDao ud = new UserDao();
		
		userS u = (userS) session.getAttribute("user");
		userS uu = ud.userdetail(u.getEmail());
		
		session.setAttribute("uu", uu);
		response.sendRedirect("MyAcc.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
