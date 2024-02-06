<%@page import="com.Model.rcgModel"%>
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
<form action="rechargeFinal">
<table>
<%! rcgModel rc = null; %>
<%rc= (rcgModel) session.getAttribute("rcg"); %>
<tr>
<td>Mobile Number</td><td> 
<input name="mobNo" disabled value="<%=rc.getMobile()%>">
 </td>
</tr>
<tr>
<td>Recharge Amount</td> <td> 
<input name="amt" disabled value="<%=rc.getAmount()%>">
</td>
</tr>
<tr class="bg-dark text-white">Card Details</tr>
<tr>
<td>Card Number</td><td> 
<input type="text" name="cardNo">
</td>
</tr>
<td>Card Holder's Name</td><td> 
<input type="text" name="hldr">
</td>
</tr>
<tr>
<td>Expiry Date</td> <td> 
<input type="text" name="exdate">
</td>
</tr>

<tr>
<td>Cvv</td> <td> 
<input type="text" name="cvv">
</td>
</tr>

</div>
<td><button type="submit">Recharge Now</button> </td>
</tr>
</table>
</form>
</div>
</div>
</div>
</center>
</body>
</html>