<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <table border=1>
              <thead>
              <tr>
                <th scope="col"></th>
                <th scope="col"></th>
                
              </tr>
            </thead>
            <tbody>
              <c:forEach  var = "i" begin = "1" end = "30" step ="1">
                 <tr>
                 
                    <td>${i}</td>
                    <td>${i+45}</td>
                    
                 </tr>
              </c:forEach>
            </tbody>
          </table>
      
</body>
</html>