<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" >
        
        <script src = "\js\script.js" type = "text/javascript"/></script>
    </head>
    <body>
        <h2>Enter admin login details :</h2>
        	<form action="/api/vehicleloans/adminlogin/ad" method="get">
        	
            <label for="adminEmail">Admin Email:</label><br>
            <input type="text" id="adEm" name="adminEmail"><br>
            
            <label for="password">Password</label><br>
            <input type="password" id="pwd" name="password">
            <br>
            <input type="submit" onclick="name();"><br>
          </form>
          
    </body>
</html>


