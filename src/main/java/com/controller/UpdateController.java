package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.Dao.UserDao;
import com.Model.userS;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
    
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		long mobNumber=Long.parseLong(request.getParameter("mobNumber")) ;
		String oldpass=request.getParameter("oldpass");
		String newpass=request.getParameter("newpass");
		
		HttpSession s = request.getSession();
		userS u = (userS) s.getAttribute("user");
		int accno = u.getAccNo();
		userS u1= new userS(username, email, mobNumber, newpass);
		if(oldpass .equals(u.getPassword()) ){
			
			UserDao ud = new UserDao();
			ud.updateuserinfo(accno, u1);
			userS uu = ud.userdetail(u.getEmail());
			s.removeAttribute("user");
			s.setAttribute("user", uu);
			response.sendRedirect("MyAcc.jsp");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
