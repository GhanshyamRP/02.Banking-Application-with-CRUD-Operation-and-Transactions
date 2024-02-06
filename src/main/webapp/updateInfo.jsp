<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%@include file="Header.jsp" %>
<%!userS u; %>
<% u=(userS)session.getAttribute("user"); %>
<div>
<div class="card d-flex justify-content-center" style="width: 400px; margin: 20px;">
<div class="card rounded">
  <div class=" text-light bg-dark form-control-lg p-2 text-center">
    Update Details
  </div>
  <div class="card-body">
  <form action="UpdateController">
<table>

<% if (u!=null){ %>

<% if (u!=null){ %>
<tr>
<td>User Name</td><td> <input name="username" value="<%=u.getUsername()%>"></td>
</tr>
<tr>
<td>Email</td> <td> <input name="email" value="<%=u.getEmail()%>"></td>
</tr>
<tr>
<td>Mobile</td> <td> <input name="mobNumber" value="<%=u.getMobNumber()%>"> </td>
</tr>
<tr>
<td>New Password</td> <td> <input name="newpass"></td>
</tr>
<tr>
<td>Old Password</td> <td> <input name="oldpass"></td>
</tr>
<tr><td> <button type="submit">Update</button></td>
</tr>
<% } %>

<% } %>

</table>
</form >
</div>
 </div>
 </div>
</div>
 

	
</body>
</html>