<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.revature.beans.Employee" %> 
  <%@ page import="com.revature.beans.Reimbursement" %> 
 <%@ page import="java.util.List" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Console</title>
</head>
<body>

<% Employee empl = (Employee)request.getSession().getAttribute("username");%>
	<%  if (empl != null) { %>
	<h3> Welcome Manager <%= empl.getUsername() %>!</h3>
	<%
	   } else {
	%>
	<h3> Please Login</h3>
	<% } %>
	
	<div>
		<% List<Employee> empllist = (List<Employee>)request.getAttribute("employeeList");%>
		<table style="width:50%">
		 <tr> 
		 	<th>id</th>
		    <th>username</th> 
		    <th>title</th>
		    <th>manager</th> 
		 </tr>
		 <%for (Employee e: empllist) { %>
		  <tr>
		     <td><%= e.getId() %></td>
		     <td><%= e.getUsername() %></td>
		     <td><%= e.getTitle() %></td>
		     <td><%= e.getManager().getUsername() %></td>
		  </tr>
		  <% } %>
		</table>	
	</div> 
	
	
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
		    <th>denied</th>    
		     
		 </tr>
		 <%for (Reimbursement r: reimb) { %>
		  <tr>
		     <td><%= r.getEmployee().getId() %></td>
		     <td><%= r.getEmployee().getUsername() %></td>
		     <td><%= r.getAmount() %></td>
		     <td><%= r.getDetails() %></td>
		     <td><%= r.getPending() %></td>
		     <td><%= r.getApproved() %></td>
		     <td><%= r.getDenied() %></td>
		     
		     <% if (r.getApproved() != 1 && r.getDenied() != 1) { %>
		     <td><a href="status?action=approve&reimid=<%= r.getId() %>">Approve</a></td> 
		     <td><a href="status?action=deny&reimid=<%= r.getId() %>">Deny</a></td> 
		     
		     <%} %>    	     
		  </tr>
		  <% } %>
		</table>	
	</div> 
	
	<div>
		<a href="logout">logout</a>
	</div>


</body>
</html>