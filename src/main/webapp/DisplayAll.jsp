<%@page import="com.Model.ErrorMsg"%>
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

<%! List<userS> ul,ual ;
	ErrorMsg em =null;
%>

<% ul =( List<userS>)session.getAttribute("UserSearchedbyEmail");
	ual =( List<userS>)session.getAttribute("alluser");
	em = (ErrorMsg ) session.getAttribute("em");
%>


<table class="table table-success table-striped" style="width: 800px; margin: 20px;">

 <thead>
    <tr>
      <th scope="col">Sr No.</th>
      <th scope="col">User Name</th>
        <th scope="col">Email</th>
      <th scope="col">Mobile Number</th>
      <th scope="col">Account Balance</th>
    </tr>
  </thead>
  <tbody>
  
  <%if(ul!=null){ 
	  int sr=1;
  for(userS u :ul){
  %>
  
    <tr>
      <th scope="row"><%=sr %></th>
      <td><%=u.getUsername() %></td>
      <td><%=u.getEmail() %></td>
      <td><%=u.getMobNumber() %></td>
      <td><%=u.getBankBal() %></td>
    </tr>
   <% 
   sr++;
  } 
  
  session.removeAttribute("UserSearchedbyEmail");}
  if(ual!=null){
	  int sr=1;
  for(userS u :ual){
	  if(u.getUsername()!="Admin"){
	  %>
	  
	    <tr>
      <th scope="row"><%=sr %></th>
      <td><%=u.getUsername() %></td>
      <td><%=u.getEmail() %></td>
      <td><%=u.getMobNumber() %></td>
      <td><%=u.getBankBal() %></td>
    </tr>
<%  sr++;
}
 
  }
  session.removeAttribute("alluser");
  }%>
  </tbody>


</table>

</body>
</html>