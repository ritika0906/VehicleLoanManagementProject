<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" >
</head>
<body>
    <h2>Enter the userdetails to register:</h2>
    <form action="/api/vehicleloans/userregister" method="post">
    <label for="Name">Name:</label><br>
    <input type="text" id="name" name="name"><br>
    
    <label for="email">Email</label><br>
    <input type="email" id="email" name="email"><br>
    
    <label for="password">Password</label><br>
    <input type="password" id="password" name="password"><br>
    
    <label for="age">Age </label><br>
    <input type="number" id="age" name="age"><br>
    
    <legend>Choose your gender:</legend>
    <label for="male">Male</label>
    <input type="radio" name="gender" id="male" value="male" checked>
    <label for="female">Female</label>
    <input type="radio" name="gender" id="female" value="female"><br><br>
    
    
    <label for="mobile">Mobile Number</label><br>
    <input type="number" id="mobile" name="mobile"><br> <br>
    
    <input type="submit" id="sub" name="sub"><br>
    

    

</form>

      

</body>
</html>
