<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.revature.beans.Employee" %> 
  <%@ page import="com.revature.beans.Reimbursement" %> 
 <%@ page import="java.util.List" %>   
 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/proj1.css">

<meta charset="UTF-8">
<title>Manager Console</title>
</head>
<body>
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
	<br>
	<br>
	<h2 class="h2login">Manage Employee Reimbursements</h2>
	<div class="list">
		<% List<Reimbursement> reimb = (List<Reimbursement>)request.getAttribute("reimbursementList");%>
		<table style="width:50%">
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
	<br>
	<br>
	<br>
	<div class="container">
	  <h2 class="h2login">Employee Login</h2>
	  <form class="loginform" action="newemployee" method="POST">
	    <div class="form-group">
	      <label for="user"></label>
	      <input id="form" style="width: 40%;" type="text" class="form-control" id="user" placeholder="Enter username" name="user">
	    </div>
	    <div class="form-group">
	      <label for="pass"></label>
	      <input id="form" style="width: 40%;" type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
	    </div>
	    <div class="form-group">
	      <label for="title"></label>
	      <input id="form" style="width: 40%;" type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    <div class="form-group">
	      <label for="manager"></label>
	      <input id="form" style="width: 40%;" type="text" class="form-control" id="manager" placeholder="Enter managerid" name="manager">
	    </div>
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form>
	</div>
	


</body>
</html>