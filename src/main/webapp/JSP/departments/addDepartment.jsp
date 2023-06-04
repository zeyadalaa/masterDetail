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
	        <h1>Add Department</h1>
	        <form action="Department" method="POST" class="add-employee-form">
	
	            <label for="departmentName">Department:</label>
	            <input type="text" name="departmentName" id="departmentName" required><br>
	
	            <label for="Section Id">Section </label>
				<select class="dropdown" name="departmentId" id="departmentId">
			        <option value="section 1" ></option>
			        <option value="section 2" ></option>
			        <option value="section 3" ></option>
				</select>
		            <input class="add" type="submit" value="Add Employee">
				
	        </form>
	    </div>
    </div>
</body>
</html>
