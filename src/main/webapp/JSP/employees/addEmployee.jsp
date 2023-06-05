<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.bibalex.Models.Department" %>
<%@ page import="org.bibalex.Models.Employee" %>
<%@ page import="org.bibalex.DAO.DepartmentDAO" %>
<%@ page import="java.util.List" %>
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
	    <%Employee employee = (Employee) request.getAttribute("employee"); %>
	    
	    			<%
					if(employee != null) {
					%>
	        			<h1>Edit Employee</h1>
		          	<%}else{ %>
	        			<h1>Add Employee</h1>
		          <%} %>
	        <form action="${pageContext.request.contextPath}/Employee" method="POST" class="add-employee-form">
				
	            <label for="firstName">First Name:</label>
				<input type="hidden" name="employeeid" value="${employee.id}">
	            <input type="text" name="firstName" id="firstName" value = "${employee.firstName}" required><br>
	
	            <label for="lastName">Last Name:</label>
	            <input type="text" name="lastName" id="lastName" value = "${employee.lastName}" required><br>
	            
	           <!--  <input type="text" name="lastName" id="lastName" required="required"
       oninvalid="this.setCustomValidity('Witinnovation')"
       onvalid="this.setCustomValidity('')"><br>-->
       
	            <label for="dob">Date of Birth:</label>
	            <input type="date" name="dob" id="dob" value = "${employee.DOB}" required><br>
	
	            <label for="email">Email:</label>
	            <input type="email" name="email" id="email" value = "${employee.email}"  required><br>
	
	            <label for="departmentId">Department Name:</label>
				<select class="dropdown" name="departmentId" id="departmentId" >
					<%
	        		DepartmentDAO departmentDAO = new DepartmentDAO();
	        		List<Department> departments = departmentDAO.getDepartment();

					for(int i = 0 ;i<departments.size();i++){
						if(employee !=null && employee.getDepartment() != null &&
								employee.getDepartment().getId() == departments.get(i).getId()){
	        		%>
					        <option selected="selected"  value="<%=departments.get(i).getId() %>" > <%=departments.get(i).getSection().getName()%>, <%=departments.get(i).getName() %>  </option>
				    <%}else if (departments.get(i) !=null){ %>
				    
				        <option value="<%=departments.get(i).getId() %>"> <%=departments.get(i).getSection().getName()%>, <%=departments.get(i).getName() %>  </option>
					<%}} %>

				</select>
				<%
					if(employee != null) {
				%>
						<input type="hidden" name="action" value="update">
		          		<input class="add" type="submit" value="Update Employee">
		          	<%}else{ %>
					  <input type="hidden" name="action" value="insert">
			          <input class="add" type="submit" value="Add Employee">
		          <%} %>
	        </form>
	    </div>
    </div>
</body>
</html>
