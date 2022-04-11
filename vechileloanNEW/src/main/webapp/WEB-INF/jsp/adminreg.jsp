<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
    <head>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" >
    </head>
    <body>
        <h2>Enter admin Register details :</h2>
        <form action="/api/vehicleloans/admin/r" method="post">
        
        
            <label for="email">email:</label><br>
            <input type="text" id="email" name="email"><br>
            
            <label for="name">name:</label><br>
            <input type="text" id="name" name="name"><br>
            
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password">
            <br>
            
            <input type="submit" id="sub" name="sub"><br>
          </form>
    </body>
</html>