<!DOCTYPE html>
<html lang="en">
<head>
  <title>WITHDRAWALS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body style="margin-left: 500px">

<div class="container">
  <h2>WITHDRAWALS</h2>
  <br>
  <br>

  <form action="/bank-mvc/app/bank/withdrawls" method="post">
    <div class="form-group">
      <label for="ACCNUMBER">ACCOUNT NUMBER:</label>
      <input type="number" class="form-control input-sm" style="width:270px" id="ACCNUMBER" placeholder="Enter ACCOUNT NUMBER" name="number" required>
    </div>
    <div class="form-group">
      <label for="AMOUNT">AMOUNT:</label>
      <input type="number" class="form-control input-sm" style="width:270px" id="AMOUNT" placeholder="Enter AMOUNT" name="amount" required>
    </div>
    <div class="checkbox">

    </div>
    <div style="margin-left:80px;">
            <button type="submit" class="btn btn-default">Submit</button></div>
  </form>
</div>

</body>
</html>
