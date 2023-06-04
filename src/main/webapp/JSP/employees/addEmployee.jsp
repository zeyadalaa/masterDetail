<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/addEmployee.css">
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <div class="AddEmployee">
	    <div class="container">
	        <h1>Add Employee</h1>
	        <form action="Employee" method="POST" class="add-employee-form">
	
	            <label for="firstName">First Name:</label>
	            <input type="text" name="firstName" id="firstName" required><br>
	
	            <label for="lastName">Last Name:</label>
	            <input type="text" name="lastName" id="lastName" required><br>
	
	            <label for="dob">Date of Birth:</label>
	            <input type="date" name="dob" id="dob" required><br>
	
	            <label for="email">Email:</label>
	            <input type="email" name="email" id="email" required><br>
	
	            <label for="departmentId">Department ID:</label>
				<select class="dropdown" name="departmentId" id="departmentId">
				   	<c:forEach items="${departments}" var="department">
				        <option value="${department.id}"> ${department.name} ${department.name} </option>
				    </c:forEach>
				</select>
		            <input class="add" type="submit" value="Add Employee">
				
	        </form>
	    </div>
    </div>
</body>
</html>
