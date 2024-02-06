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
<center>
<div class="card d-flex justify-content-center" style="width: 400px; margin: 20px;">
<div class="card rounded">
  <div class=" text-light bg-dark form-control-lg p-2 text-center">
   Recharge Portal
  </div>
  <div class="card-body">
<table>
<form action="RechargeController">
<tr>
<td>Mobile Number</td> <td> 
<input type="number" name="mobNumber" >
 </td>
</tr>
<tr>
<td>Recharge Amount</td> <td> 
<input type="text" name="amount">
</td>
</tr>

</div>
<td><button type="submit">Recharge  Now</button> </td>
</tr>
</form>
</table>
</div>
</div>
</div>
</center>
</body>
</html>