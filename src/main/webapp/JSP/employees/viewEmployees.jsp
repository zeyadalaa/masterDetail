
<%@page import="org.bibalex.Servlet.EmployeeServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ page import="org.bibalex.Models.Employee" %>
<%@ page import="org.bibalex.DAO.EmployeeDAO" %>
<%@ page import="java.util.List" %>
<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="jquery-3.6.0.min.js"></script> -->


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css">
<meta charset="ISO-8859-1">    
<title>Master Detail</title>
</head>
<body>
    <div class="container">
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/JSP/employees/viewEmployees.jsp">Employee</a></li>
                <li><a href="${pageContext.request.contextPath}/JSP/departments/viewDepartments.jsp">Department</a></li>
                <li><a href="${pageContext.request.contextPath}/JSP/sections/viewSections.jsp">Section</a></li>
            </ul>
        </nav>
    </div>
	<div class="container">
	    <table>
	        <tr>
	            <th>First Name</th>
	            <th>Last Name</th>
	            <th>DOB</th>
	            <th>Email</th>
	            <th>Department Name</th>
	            <th>Section Name</th>
	            <th>Actions</th>
	        </tr>
	        
      		<tr class="rows">
        		<%
	        		EmployeeDAO employeeDAO = new EmployeeDAO();
	        		List<Employee> employees = employeeDAO.getEmployees();
	        	
					for(int i = 0 ;i<employees.size();i++){
	        	%>
	        		   <tr class="rows">
	       			   <td><%out.println(employees.get(i).getFirstName()); %></td>
	       			   <td><%out.println(employees.get(i).getLastName()); %></td>
	       			   <td><%out.println(employees.get(i).getDOB()); %></td>
	       			   <td><%out.println(employees.get(i).getEmail()); %></td>
	       			   <td><%out.println(employees.get(i).getDepartment().getName()); %></td>
	       			   <td><%out.println(employees.get(i).getDepartment().getSection().getName()); %></td> 
	       			   <td>
		       			   <div class="action-buttons">
			       			   <form action="${pageContext.request.contextPath}/Employee" method="POST">
								  <input type="hidden" name="action" value="edit" >
								  <input type="hidden" name="employeeid" value="<%=employees.get(i).getId() %>">
					                <button type="submit" class="updateButton">Update</button>
							   </form>
							   
			       			   <form action="${pageContext.request.contextPath}/Employee" method="POST">
								  <input type="hidden" name="action" value="delete">
								  <input type="hidden" name="employeeid" value="<%=employees.get(i).getId() %>">
				                	<button type="submit" class="deleteButton">Delete</button>
							   </form>
						   </div>
			            </td>
				   <%}%> 
	        </tr>
		</table>
		
		<%-- <td><a href="edit?id=<%= employees.get(i).getId() %>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=<%= employees.get(i).getId() %>">Delete</a></td>
    		 --%>		
	        			<!-- <tr class="rows"> -->
	            <%-- <td><%= employee.getId() %></td>
	            <td><%= employee.getFirst_name() %></td>
	            <td><%= employee.getLast_name() %></td>
	            <td><%= employee.getDOB() %></td>
	            <td><%= employee.getEmail() %></td>
	            <td><%= employee.getDepartment_id() %></td> --%><!-- 
	            <td>
	                <button>Delete</button>
	                <button>Update</button>
	            </td> -->
	    <form action="${pageContext.request.contextPath}/Employee" method="POST">
		  <input type="hidden" name="action" value="add">
		  <button type="submit" class="addButton">Add New Employee</button>
		</form>
	    <!-- <button  class="addButton">Add</button> -->
    </div>

</body>

</html>