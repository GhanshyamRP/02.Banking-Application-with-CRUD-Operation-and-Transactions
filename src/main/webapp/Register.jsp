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

<div>
<center>
<div class="card d-flex justify-content-center" style="width: 400px; margin: 20px;">
<div class="card rounded">
  <div class=" text-light bg-dark form-control-lg p-2 text-center">
    Ragister 
  </div>
  <div class="card-body">

<form action="registerController">
<table>

<tr>
<td>User Name  </td> <td> <input  name="username"> </td>
</tr>
<tr>
<td>Email  </td> <td> <input name="email"> </td>
</tr>
<tr>
<td>Mobile </td> <td> <input name="mobNumber"> </td>
</tr>
<tr>
<td>Password </td> <td> <input name="password"> </td>
</tr>
<tr>
<td><button type="submit">Register</button> </td>
</tr>

</table>
</form>
</div>
 
 </div>
 </div>
 </center>
	</div>
</body>
</html>