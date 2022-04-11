<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" >
    </head>
    <body>
        <form action="/api/vehicleloans/userdetails">
            <label for="address">Address:</label><br>
            <input type="text" id="address" name="address"><br>
            
            
            <label for="state">State:</label><br>
            <input type="text" id="state" name="state"><br>
            
            <label for="city">City:</label><br>
            <input type="text" id="city" name="city"><br>
            
            <label for="pin">Pincode:</label><br>
            <input type="number" id="pin" name="pin"><br>
            
            <label for="emptype">Emptype:</label><br>
            <input type="text" id="emptype" name="emptype"><br>
            
            <label for="salary">Salary:</label><br>
            <input type="number" id="salary" name="salary"><br>
            
            <label for="aadhar">Aadhar:</label><br>
            <input type="text" id="aadhar" name="aadhar"><br>
            
            <label for="pan">Pan:</label><br>
            <input type="text" id="pan" name="pan"><br>
            
            <label for="salarySlip">Salary slip:</label><br>
            <input type="text" id="salarySlip" name="salarySlip"><br>
            
            <label for="addressProof">Address proof:</label><br>
            <input type="text" id="addressProof" name="addressProof"><br>
            <br>
            
            <input type="submit" id="sub" name="sub"><br>


        </form>
    </body>
</html>