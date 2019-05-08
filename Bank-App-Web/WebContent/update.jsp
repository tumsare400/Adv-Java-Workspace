<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Online Net Banking</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>

<body class="bg-light">
       <div class="container">
          <form action="update-bankaccount-details.do" method="post" style="margin-top:50px">
                <div class="form-row">
                          <div class="form-group col-md-12">
                          <label for="validationServer01"  class="text-dark">Account ID:</label>
                            <input type="number" class="form-control is-invalid" name="accountId" value="${account.accountId}" readonly="readonly" id="validationServer01" required  >
                          </div><br/>

                          <div class="form-group col-md-12">
                                <label for="validationServer01"  class="text-dark">Customer Name:</label>
                                  <input type="text" class="form-control is-invalid"   name="accountHolderName" value="${account.accountHolderName}" id="validationServer01" required >
                                </div><br/>

                          <div class="form-group col-md-12">
                                <label for="validationServer02"  class="text-dark">Account Type:</label>
                                  <select class="custom-select my-1 mr-sm-2"  name="accountType" value="${account.accountType}"id="inlineFormCustomSelectPref">
                                      <option selected>...Select...</option>
                                      <option value="saving">SAVING</option>
                                      <option value="current">CURRENT</option>
                                  </select>
                          </div>
                </div>
                <br/>

                <div class="form-group col-md-12">
                    <label for="validationServer01"  class="text-dark">Account Balance:</label>
                      <input type="number" class="form-control is-invalid" name="accountBalance" value="${account.accountBalance}" placeholder="Enter Account No"  id="validationServer01"  readonly required>
                </div>
                 <br/>
                 
                <input type="submit" class="btn bg-dark text-white" value="Submit"/>
          </form>
      </div>
      
</body>

</html>