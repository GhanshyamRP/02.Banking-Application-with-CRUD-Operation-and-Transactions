package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CommonDao;
import com.Dao.UserDao;
import com.Model.ErrorMsg;
import com.Model.Login;
import com.Model.userS;

@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginController() {
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 Login userlog=null;
		
			 String email = request.getParameter("email");
			 String pass = request.getParameter("password");
			 
			 userlog = new Login(email, pass); 
			 ErrorMsg em = null; 
			 System.out.println(email);
			 
	 if(userlog.getEmail().equals("Admin") ) {
		 
			 System.out.println("Admin Log in");
			 if(userlog.getPass().equals("Admin")) {
				 session.removeAttribute("em");
				 userS u = new userS(email, pass,"Admin");
				 session.setAttribute("user", u);
				 System.out.println("Password Match");
				 response.sendRedirect("DashBoard.jsp");
			 }
			 else {
				 em=new ErrorMsg(2, "Password not Match");
				 session.removeAttribute("em");
				 session.setAttribute("em", em);
				 response.sendRedirect("Login.jsp");
			 }
			 
		 
	 }else {
		 CommonDao cd =new CommonDao();
		 Login user = cd.finduser(email);
		
		 if(user!=null) {
			 System.out.println("User found");
			 if(pass.equals(user.getPass())) {
				 session.removeAttribute("em");
				  UserDao ud = new UserDao();
				  userS u = ud.userdetail(email);
				 session.setAttribute("user", u);
				 System.out.println("Password Match");
				 response.sendRedirect("DashBoard.jsp");
			 }
			 
			 else {
				 em=new ErrorMsg(2, "Password not Match");
				 session.removeAttribute("em");
				 session.setAttribute("em", em);
				 response.sendRedirect("Login.jsp");
			 }
			 
		 }
		 else {
			 em=new ErrorMsg(1, "User not found");
			 session.setAttribute("em", em);
			 response.sendRedirect("Login.jsp");
		 }
	 }
		
	 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
