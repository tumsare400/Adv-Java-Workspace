<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <table border=1 class="table table-hover" style="margin-top:50px">
            <thead>
              <tr>
                <th scope="col">Account ID.</th>
                <th scope="col">Account Holder Name</th>
                <th scope="col">Account Type</th>
                <th scope="col">Account Balance</th>
              </tr>
            </thead>
            <tbody>
                 <tr>
                  <!-- internally calling getter method (obj.property)-->
                    <td>${account.accountId} </td>
                    <td>${account.accountHolderName}</td>
                    <td>${account.accountType}</td>
                    <td>${account.accountBalance}</td>
                 </tr>
            </tbody>
          </table>
</body>
</html>