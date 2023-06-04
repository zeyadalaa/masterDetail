<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/addEmployee.css">
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <div class="AddDepartment">
	    <div class="container">
	        <h1>Add Section</h1>
	        <form action="Department" method="POST" class="add-employee-form">
	
	            <label for="departmentName">Section Name:</label>
	            <input type="text" name="departmentName" id="departmentName" required><br>
	
	            <input class="add" type="submit" value="Add Employee">
				
	        </form>
	    </div>
    </div>
</body>
</html>
