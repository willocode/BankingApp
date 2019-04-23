<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="styles/proj1.css">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<% String message = (String)request.getAttribute("successMessage");  %>
	<%  if (message != null) { %>
	<h3> <%= message %>!</h3>
	<%
	   } else {
	%>
	<% } %>

<div class="container">
  <h2 class="h2login">Employee Login</h2>
  <form class="loginform" action="login" method="POST">
    <div class="form-group">
      <label for="username"></label>
      <input id="form" style="width: 40%;" type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>
    <div class="form-group">
      <label for="password"></label>
      <input id="form" style="width: 40%;" type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
