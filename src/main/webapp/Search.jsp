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
   Search By Email
  </div>
  <div class="card-body">

<form action="search">
<table>
<tr>
        <th class="text-dark p1">Email </th>
          <td> <input name="email"></td>
        </tr>
        <tr>
        <td><button type="submit">Search</button> </td>
         </tr>
</table>
</form>
</div>
</div>
</div>
</center>
</body>
</html>