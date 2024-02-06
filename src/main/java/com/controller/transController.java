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

@WebServlet("/transController")
public class transController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public transController(){
    	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int transby =  Integer.parseInt(request.getParameter("accNo"));
		int ifsc= Integer.parseInt(request.getParameter("ifsc"));
		
		String accHolder=request.getParameter("accHolder");
		int amt= Integer.parseInt(request.getParameter("amount"));
		String trtype = request.getParameter("trtype");
		
		System.out.println(trtype);
		
		HttpSession session = request.getSession();
		userS u = (userS)session.getAttribute("user"); 
		int accno = u.getAccNo();
		transaction tr = new transaction(accno, transby, ifsc,  accHolder, amt,trtype , null);
		UserDao ud  = new UserDao();
		int i = ud.transaction (tr);
		int p=0;
		if(tr.getTrtype().equals("Credit") ) {
			System.out.println("Credit operation");
			p =ud.addBal(accno, amt);
		}else {
			System.out.println("Debit operation");
			p =ud.deductBal(accno, amt);
		}
		 
		if(i>0 && p>0){
			
			System.out.println("transaction complited");
			List<transaction> trnlist = ud.trnhistory(u.getAccNo());
			
			if(trnlist!=null) {
				session.setAttribute("trnhist", trnlist);
				response.sendRedirect("lastTrans.jsp");
			}
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
