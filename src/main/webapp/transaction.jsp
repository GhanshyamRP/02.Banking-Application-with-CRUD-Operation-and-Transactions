<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
<script src="registerscript.js"></script>
</head>
<body>
<%@include file="Header.jsp" %>
<center>
<div class="card d-flex justify-content-center" style="width: 400px; margin: 20px;">
<div class="card rounded">
  <div class=" text-light bg-dark form-control-lg p-2 text-center">
   Fund Transfer Detail
  </div>
  <div class="card-body">
<form action="transController">
<table>
<tr>
<td>Transaction Type</td> <td> 
<select name="trtype" id="trtype" onselect="choise();"> 
<option value="Credit">Credit</option>
<option value="Debit">Debit</option>
</select>
 </td>
 <div id="cr">
</tr>
<tr>
<td>Accout Number</td> <td> 
<input name="accNo">
 </td>
</tr>
<tr>
<td>IFSC Code</td> <td> 
<input name="ifsc">
</td>
</tr>
<tr>
<td>Account Holder Name</td>
<td><input name="accHolder"></td>
</tr>
<tr>
<td>Amount</td>
<td><input name="amount"></td>
</tr>
</div>
<td><button type="submit">Transfer</button> </td>
</tr>
</table>
</form>
</div>
</div>
</div>
</center>
</body>
</html>