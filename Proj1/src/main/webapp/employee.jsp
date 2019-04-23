<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.revature.beans.Employee" %>
 <%@ page import="com.revature.beans.Reimbursement" %>  
 <%@ page import="java.util.List" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	
	<h2>Hello employee world</h2>
	
	<% Employee empl = (Employee)request.getSession().getAttribute("username");%>
	<%  if (empl != null) { %>
	<h3> Welcome <%= empl.getUsername() %>!</h3>
	<%
	   } else {
	%>
	<h3> Please Login</h3>
	<% } %>
	<br>
	<br>
	
	<div>
		<% List<Reimbursement> reimb = (List<Reimbursement>)request.getAttribute("reimbursementList");%>
		<table style="width:50%">
		 <tr> 
		 	<th>Employee id</th>
		    <th>Employee Username</th> 
		    <th>amount</th>
		    <th>details</th>
		    <th>pending</th> 
		    <th>approved</th> 
		    
		     
		 </tr>
		 <%for (Reimbursement r : reimb) { %>
		  <tr>
		     <td><%= r.getEmployee().getId() %></td>
		     <td><%= r.getEmployee().getUsername() %></td>
		     <td><%= r.getAmount() %></td>
		     <td><%= r.getDetails() %></td>
		     <td><%= r.getPending() %></td>
		     <td><%= r.getApproved() %></td> 
		         	     
		  </tr>
		  <% } %>
		</table>	
	</div> 
	
	
	
	<div class="container">
  <h2>Employee Reimbursement</h2>
  <form action="reimbursement" method="POST">
    <div class="form-group">
      <label for="amount">Amount:</label>
      <input type="text" class="form-control" id="amount" placeholder="Enter amount" name="amount">
    </div>
    <div class="form-group">
      <label for="details">Details:</label>
      <input type="text" class="form-control" id="details" placeholder="Enter details" name="details">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
	
	<div>
  	<a href="logout">logout</a>
  </div>	
</body>
</html>