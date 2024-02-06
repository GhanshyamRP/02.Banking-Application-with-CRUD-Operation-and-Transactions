<%@page import="com.Model.userS"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style type="text/css">

body{
	background-image: url("https://community.hpe.com/t5/image/serverpage/image-id/117411i93CC98F24267028E/image-size/large?v=v2&px=2000");
	background-size: cover;
	margin:0%;
}</style>
</head>
<body>
<nav class="navbar navbar-expand-lg .bg-info .bg-gradient bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand  fw-bolder" href="#">SN Bank</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
       <ul class="navbar-nav">
        <%!String role;%>
        <%if(session.isNew() || session.getAttribute("user") == null){ %>
    	<li class="nav-item">
       	 	<a class="nav-link" href="HomeView.jsp">Home</a>
        </li>
        <li>
    	 	<a class="nav-link" href="Register.jsp">Register</a>
    	</li>
    	<li>
    		<a class="nav-link" href="Login.jsp">Login</a>
    	</li>
	    <%
	        }else if (session.getAttribute("user") != null){
	     	  userS u =(userS) session.getAttribute("user");
	     	   if(u!=null){
	    %>
    	<li class="nav-item">
    	<a class="nav-link" href="MyAcc.jsp" style="color: red">Hello, <%=u.getUsername() %></a>
    	</li>
    <%
    	if (u.getEmail().equals("Admin") ){
    %>
    	<li class="nav-item">
    	<form action="Display">
          <button  class="nav-link" type="submit">Display List</button>
        </form>
        </li>
        <li class="nav-item">
        <a class="nav-link" href="Search.jsp">Search </a>
        </li>
    	<!--  li class="nav-item">
          <a class="nav-link" href="RemoveReq.jsp">Remove</a>
        </li-->
    	<% 
			}else {
		%>
    	<li class="nav-item">
       		 <a class="nav-link" href="transaction.jsp">Transaction</a>
        </li>
        <li class="nav-item">
       		 <a class="nav-link" href="trnhistory">Transaction History</a>
        </li>  
        <li class="nav-item">
       		 <a class="nav-link" href="myAcc">Account Detail</a>
        </li>
    	<li class="nav-item">
          <a class="nav-link" href="Recharge.jsp">Recharge</a>
        </li>
       <%
     	   }
    	%>
  		<li class="nav-item"><form>
			 <a class="nav-link" href="Logout">Logout</a>  </form>
		</li>
     	<%
     	 }
    }
       %>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>