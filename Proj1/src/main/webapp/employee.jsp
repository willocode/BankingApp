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
<title>Welcome</title>
</head>
<body>
	<div>
		<% Employee empl = (Employee)request.getSession().getAttribute("username");%>
		<%  if (empl != null) { %>
		<h3> Welcome <%= empl.getUsername() %>!</h3>
		<h3> Your manager is <%= empl.getManagerId() %>(venus)</h3>
		<%
		   } else {
		%>
		<h3> Please Login</h3>
		<% } %>

  		<a href="logout">logout</a>
  	</div>
	<br>
	<br>
	<br>
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
		 <%for (Reimbursement r : reimb) { %>
		  <tr>
		     <td class="td"><%= r.getEmployee().getId() %></td>
		     <td class="td"><%= r.getEmployee().getUsername() %></td>
		     <td class="td">$<%= r.getAmount() %></td>
		     <td class="td"><%= r.getDetails() %></td>
		     <td class="td"><%= r.getPending() %></td>
		     <td class="td"><%= r.getApproved() %></td> 
		     <td class="td"><%= r.getDenied() %></td> 
		     
		         	     
		  </tr>
		  <% } %>
		</table>
			
	</div> 
	<br>
	<br>
<div class="container">
  <h2 class="h2login">Employee Reimbursement</h2>
  <form class="loginform" action="reimbursement" method="POST">
    <div class="form-group">
      <label for="amount"></label>
      <input style="font-size:20px;" type="text" class="form-control" id="amount" placeholder="Enter amount" name="amount">
    </div>
    <div class="form-group">
      <label for="details"></label>
      <input style="font-size:20px;" type="text" class="form-control" id="details" placeholder="Enter details" name="details">
    </div>
    <button style="font-size:15px;" type="submit" class="btn btn-default">Submit</button>
  </form>
</div>		
</body>
</html>