<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>REGISTER </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body style="margin-left: 500px">

    <div class="container">
        <BR>

        <h1>
            <font color="BLACK">REGISTER</font>
        </h1> <br>
        <br>

        <form action="/bank-mvc/app/bank/new" method="post">
            <div class="form-group">
                <label for="Name">CUSTOMER NAME:</label>
                <input type="text" class="form-control input-sm" style="width:270px" id="text" placeholder="Enter NAME"
                    name="customer_name" required>
            </div>
            <div class="form-group">
                <label for="type">ACCOUNT TYPE:</label>
                <select name="account_type" required>
                    <option value="">SELECT</option>
                    <option value="Current">CURRENT</option>
                    <option value="Savings">SAVINGS</option>
                </select>
            </div>
            <div class="form-group">
                    <label for="number">ACCOUNT BALANCE:</label>
                    <input type="number" class="form-control input-sm" style="width:270px" id="number" placeholder="Enter Amount"
                        name="account_balance" required>
                <br>
            <div style="margin-left:80px;">
                <button type="submit" class="btn btn-default">REGISTER</button></div>
        </form>
    </div>

</body>

</html>