
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

<%@include file="Header.jsp" %>
</head>

<body >
<center>
<div class="card d-flex justify-content-center" style="width: 400px; margin: 20px;">
<div class="card rounded">
  <div class=" text-light bg-dark form-control-lg p-2 text-center">
    Login 
  </div>
  <div class="card-body">

<form action="loginController">
<table>

<%!Login ul1 =null;
	ErrorMsg em = null;%>
	<%  ul1 = (Login)session.getAttribute("userlog");
		em = (ErrorMsg) session.getAttribute("em");
	%>
<tr>
<td>Email </td> <td> 
<input name="email">
 </td>
</tr>
<tr>
<td class="text-danger fw-bold">
<%if(!session.isNew()&& session.getAttribute("em")!=null){ %>
<%if(em.getErrcode()==1){ %>
<%=em.getMsg()%>
<% } }%>
</td>
</tr>
 <tr>
<td>Password </td><td><input name="password"></td>
</tr>

<tr>
<td class="text-danger fw-bold"> 
<%if(!session.isNew() && session.getAttribute("em")!=null){ %>
<%if(em.getErrcode()==2){ %>
<%=em.getMsg()%>
<% } } %>
 </td> </tr>
<tr>
<td><button type="submit">Login</button> </td>
</tr>
<tr>
        <th class="text-dark p1">New Here ?</th>
          <td> <a class="nav-link btn btn-primary" href="Register.jsp" >Sign Up</a></td>
        </tr>
</table>
</form>
</div>
</div>
</div>
</center>
</body>
</html>