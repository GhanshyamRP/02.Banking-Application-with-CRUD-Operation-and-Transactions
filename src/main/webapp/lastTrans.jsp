<%@page import="com.Model.transaction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>

<%! List<transaction> trn =null; %>
<% trn=(List<transaction>)session.getAttribute("trnhist"); %>
<table class="table table-success table-striped" style="width: 800px; margin: 20px;">

 <thead>
    <tr>
      <th scope="row">Sr. No.</th>
      <td>Amount</td>
      <td>Transaction Type</td>
      <td>Transfer By Account</td>
      <td>Transfer By</td>
      <td>Transfer On</td>
    </tr>
  </thead>
  <tbody>
  
  <%if(trn!=null){ 
	  int sr=1;
  for(transaction t :trn){
	  String c;
	  if(t.getTrtype().equals("Credit") ){
		  c="text-success";
	  }else{
		  c="text-danger";
	  }
  %>

    <tr class="<%=c%>">
      <th scope="row"><%=sr %></th>
      <td><%=t.getAmt() %></td>
      <td><%=t.getTrtype() %></td>
      <td><%=t.getTransby() %></td>
      <td><%=t.getAccHolder() %></td>
      <td><%=t.getTrndate() %></td>
    </tr>
   <% 
   sr++;
  } 
  
  session.removeAttribute("trnhist");
  } %>
  </tbody>


</table>


</body>
</html>