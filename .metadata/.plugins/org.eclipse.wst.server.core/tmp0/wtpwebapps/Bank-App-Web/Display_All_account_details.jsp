<!-- Tag based library in jsp -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   
</head>
<body>
       <table class="table table-hover" style="margin-top:50px">
            <thead>
              <tr>
                <th scope="col">Account ID.</th>
                <th scope="col">Account Holder Name</th>
                <th scope="col">Account Type</th>
                <th scope="col">Account Balance</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="account" items="${accounts}">
                 <tr>
                  <!-- internally calling getter method (obj.property)-->
                    <td>${account.accountId} </td>
                    <td>${account.accountHolderName}</td>
                    <td>${account.accountType}</td>
                    <td>${account.accountBalance}</td>
                 </tr>
              </c:forEach>
            </tbody>
          </table>
</body>
</html>