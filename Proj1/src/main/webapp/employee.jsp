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
<title>Welcome</title>
</head>
<body>
	<div style="background:#FBF8F8;">
	<div>
		<% Employee empl = (Employee)request.getSession().getAttribute("username");%>
		<%  if (empl != null) { %>
		<h2> Welcome <%= empl.getUsername() %>!</h2>
		<h4> Your manager is <%= empl.getManagerId() %>(venus)</h4>
		<%
		   } else {
		%>
		<h3> Please Login</h3>
		<% } %>

  		<a href="logout">logout</a>
  	</div>
  	</div>
	<br>
	<br>
	<br>
	<h2 style="text-align:center;">Your Reimbursements</h2>
	<div style="background:#FBF8F8; width: 80vw; display: block; margin: auto;">
	<div class="list">
		<% List<Reimbursement> reimb = (List<Reimbursement>)request.getAttribute("reimbursementList");%>
		<table style="width:60%">
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
	</div> 
	<br>
	<br>
<div style="background:#FBF8F8; height:20vh; width: 60vw; display: block; margin: auto;">
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
    <button style="font-size:15px; margin: 10px;" type="submit" class="btn btn-default">Submit</button>
  </form>
</div>	
</div>	
<br>
<br>

<div style="background:#FBF8F8; height:20vh; width: 60vw; display: block; margin: auto;">
<div class="container">
  <h2 class="h2login">Update employee</h2>
  <form class="loginform" action="updateuser" method="POST">
    <div class="form-group">
      <label for="username"></label>
      <input style="font-size:20px;" type="text" class="form-control" id="username" placeholder="Enter new username" name="username">
    </div>
    <div class="form-group">
      <label for="password"></label>
      <input style="font-size:20px;" type="password" class="form-control" id="password" placeholder="Enter new password" name="password">
    </div>
    <div class="form-group">
      <label for="title"></label>
      <input style="font-size:20px;" type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    <!-- <div class="form-group">
      <label for="managerid"></label>
      <input style="font-size:20px;" type="text" class="form-control" id="managerid" placeholder="Enter manager id" name="manager">
    </div> -->
    <button style="font-size:15px; margin: 10px;" type="submit" class="btn btn-default">Submit</button>
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