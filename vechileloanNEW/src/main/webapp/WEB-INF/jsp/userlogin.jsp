<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" >
    
    <script src = "\js\script1.js" type = "text/javascript"/></script>
</head>
<body>
    <h2>Enter user login details :</h2>
    <form action="/api/vehicleloans/userlogin/ul" method="get" >
    
         <label for="email">User Email:</label><br>
        <input type="email" id="uem" name="userEmail"><br>
        
        <label for="password">Password</label><br>
        <input type="password" id="upwd" name="password">
        
        <br>
            <input type="submit" onclick="name1(); "><br>
    

      </form>
</body>
</html>
