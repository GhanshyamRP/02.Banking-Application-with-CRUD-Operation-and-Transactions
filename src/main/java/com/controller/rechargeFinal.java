
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
import com.Model.rcgModel;
import com.Model.transaction;
import com.Model.userS;


@WebServlet("/rechargeFinal")
public class rechargeFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public rechargeFinal() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int cardNo=Integer.parseInt(request.getParameter("cardNo")) ;
		String	exdate= request.getParameter("exdate");
		String cvv = request.getParameter("cvv");
		userS u = (userS) session.getAttribute("user");
		rcgModel rc = (rcgModel) session.getAttribute("rcg");
		int amt = rc.getAmount();
		String hldr=request.getParameter("hldr");
		String op = "Debit";
		transaction tr = new transaction( u.getAccNo(), cardNo,0,hldr,amt,op, null);
		UserDao ud = new UserDao();
		
		int i = ud.deductBal(u.getAccNo(), rc.getAmount() );
		int p = ud.transaction(tr);
		if(i>0 && p>0) {
			response.sendRedirect("RechargeSuccess.jsp");
			System.out.println("Recharge Done");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
