package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.Model.transaction;
import com.Model.userS;

@WebServlet("/trnhistory")
public class trnhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public trnhistory() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		userS u = (userS)session.getAttribute("user");
		UserDao ud = new UserDao();
		
		List<transaction> trnlist = ud.trnhistory(u.getAccNo());
		if(trnlist!=null) {
			session.setAttribute("trnhist", trnlist);
			response.sendRedirect("lastTrans.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
