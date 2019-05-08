<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>HOME PAGE</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.button {
	background-color: rgb(21, 2, 65);
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container"></div>
	<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><img src="images/logo.jpg" width="100"
				height="60"></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/new_account">Create New Account</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/withdrawPage">Withdrawals</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/depositPage">Deposits</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/fundsPage">Funds</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/cbPage">Check Balance</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/dadPage">Display Account Details</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/deletePage">Delete Account</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/updatePage">Update bank Details</a></li>
			<li class="nav-item"><a class="nav-link" href="/bank-mvc/app/bank/searchAccountPage">Search Account</a></li>
		</ul>

	</nav>
	<br>
	<br>
		<center><a href="login1.jsp" class="button"> Login</a></center>
</body>
</html>




