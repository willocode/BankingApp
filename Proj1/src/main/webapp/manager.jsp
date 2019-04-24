<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.revature.beans.Employee" %> 
  <%@ page import="com.revature.beans.Reimbursement" %> 
 <%@ page import="java.util.List" %>   
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="styles/proj1.css">

<meta charset="UTF-8">
<title>Manager Console</title>
</head>
<body>

<div style="background:#FBF8F8;">
<div>
<% Employee empl = (Employee)request.getSession().getAttribute("username");%>
	<%  if (empl != null) { %>
	<h3> Welcome Manager <%= empl.getUsername() %>!</h3>
	<%
	   } else {
	%>
	<h3> Please Login</h3>
	<% } %>
	
	
		<a href="logout">logout</a>
	</div>
	</div>
	<div style="background:#FBF8F8; width: 60vw; display: block; margin: auto;">
	<h2 class="h2login">All Employees</h2>
	<div class="list">
		<% List<Employee> empllist = (List<Employee>)request.getAttribute("employeeList");%>
		<table style="width:30%">
		 <tr> 
		 	<th>ID</th>
		    <th>Username</th> 
		    <th>Title</th>
		    <th>Manager</th> 
		 </tr>
		 <%for (Employee e: empllist) { %>
		  <tr>
		     <td class="td"><%= e.getId() %></td>
		     <td class="td"><%= e.getUsername() %></td>
		     <td class="td"><%= e.getTitle() %></td>
		     <td class="td"><%= e.getManager().getUsername() %></td>
		  </tr>
		  <% } %>
		</table>	
	</div>
	</div> 
	<br>
	<br>
	<h2 class="h2login">Manage Employee Reimbursements</h2>
	<div style="background:#FBF8F8; width: 60vw; display: block; margin: auto;">
	<div class="list">
		<% List<Reimbursement> reimb = (List<Reimbursement>)request.getAttribute("reimbursementList");%>
		<table style="width:80%">
		 <tr> 
		 	<th>Employee id</th>
		    <th>Employee Username</th> 
		    <th>Amount</th>
		    <th>Details</th>
		    <th>Pending</th> 
		    <th>Approved</th>
		    <th>Denied</th>    
		     
		 </tr>
		 <%for (Reimbursement r: reimb) { %>
		  <tr>
		     <td class="td"><%= r.getEmployee().getId() %></td>
		     <td class="td"><%= r.getEmployee().getUsername() %></td>
		     <td class="td">$<%= r.getAmount() %></td>
		     <td class="td"><%= r.getDetails() %></td>
		     <td class="td"><%= r.getPending() %></td>
		     <td class="td"><%= r.getApproved() %></td>
		     <td class="td"><%= r.getDenied() %></td>
		     
		     <% if (r.getApproved() != 1 && r.getDenied() != 1) { %>
		     <td><a href="status?action=approve&reimid=<%= r.getId() %>">Approve</a></td> 
		     <td><a href="status?action=deny&reimid=<%= r.getId() %>">Deny</a></td> 
		     
		     <%} %>    	     
		  </tr>
		  <% } %>
		</table>	
	</div> 
	</div>
	<br>
	<br>
	<div style="background:#FBF8F8; width: 60vw; height:30vh; display: block; margin: auto;">
	<div class="container">
	  <h2 class="h2login">New Hire Information</h2>
	  <form class="loginform" action="newemployee" method="POST">
	    <div class="form-group">
	      <label for="user"></label>
	      <input id="form" style="width: 20%; font-size: 15px;" type="text" class="form-control" id="user" placeholder="Enter username" name="user">
	    </div>
	    <div class="form-group">
	      <label for="pass"></label>
	      <input id="form" style="width: 20%; font-size: 15px;" type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
	    </div>
	    <div class="form-group">
	      <label for="title"></label>
	      <input id="form" style="width: 20%; font-size: 15px;" type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    <div class="form-group">
	      <label for="manager"></label>
	      <input id="form" style="width: 20%; font-size: 15px;" type="text" class="form-control" id="manager" placeholder="Enter managerid" name="manager">
	    </div>
	    <button style="font-size: 15px; margin: 10px;" type="submit" class="btn btn-default">Submit</button>
	  </form>
	</div>
	</div>
	<br>
	<br>
	<br>
</body>

<footer style="margin: 40px; text-align: center;" class="templateux-footer">
 <div class="col-md-6 text-md-right text-center footer-social">
    <a href="https://github.com/willobot" target="_blank" class="p-3"><span class="fa fa-github fa-3x"></span></a>
 </div>
</footer>
</html>