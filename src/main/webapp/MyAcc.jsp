
<%@page import="javax.websocket.Session"%>
<%@page import="com.Model.ErrorMsg"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.Model.userS"%>
<%@page import="com.Model.Login"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>

<body >
<%@include file="Header.jsp" %>

<center>
<div class="card d-flex justify-content-center" style="width: 600px; margin: 20px;">
<div class="card rounded">
  <div class=" text-light bg-dark form-control-lg p-2 text-center">
    My Account Detail
  </div>
  <div class="card-body">



<%! userS u;
%>

<% 
u =(userS)session.getAttribute("user");
%>


<table class="table table-success table-striped" style="width: 500px; margin: 20px;">


 <%if(u!=null){ 
  %>
   <tbody>
    <tr>
      <th scope="col">User Name</th>
       <td><%=u.getUsername() %></td>
    </tr>
    <tr>
      <th scope="col">Email</th>
       <td><%=u.getEmail() %></td>
    </tr>
    <tr>
      <th scope="col">Mobile Number</th>
       <td><%=u.getMobNumber() %></td>
    </tr>
    <tr>
      <th scope="col">Available Balance</th>
       <td><%=u.getBankBal()%></td>
    </tr>
 	<tr>
      <th scope="col"><form action="updateInfo.jsp"><button type="submit">Update Account</button></form> </th>
      <th scope="col"><form action="delreqController"><button type="submit">Delete Account</button></form></th>
    </tr>
 <%} %>
  </tbody>

</table>

</div>
</div>
</div>
</center>
</body>
</html>