<%@page import="org.bibalex.Servlet.EmployeeServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ page import="org.bibalex.Models.Section" %>
<%@ page import="org.bibalex.DAO.SectionDAO" %>
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
                <li><a href="#">Employee</a></li>
                <li><a href="#">Department</a></li>
                <li><a href="#">Section</a></li>
            </ul>
        </nav>
    </div>
	<div class="container">
	    <table>
	        <tr>
	            <th>Section Name</th>
	            <th>Actions</th>
	        </tr>
	        <%-- JSP code to retrieve and display data from the database --%>
	        <%
	            // Assuming you have a list of employees retrieved from the database
	            //List<Employee> employees = getEmployeesFromDatabase();
	
	            //for (Employee employee : employees) {
	        %>
	        
      			<tr class="rows">
	            <%-- <td><%= employee.getId() %></td>
	            <td><%= employee.getFirst_name() %></td>
	            <td><%= employee.getLast_name() %></td>
	            <td><%= employee.getDOB() %></td>
	            <td><%= employee.getEmail() %></td>
	            <td><%= employee.getDepartment_id() %></td> --%>
	            <td>zeyad</td>
	            <td>
	                <button>Delete</button>
	                <button>Update</button>
	            </td>
	        </tr>
	       <%--  <% } %> --%>
	    </table>
	    <form action="${pageContext.request.contextPath}/Employee" method="POST">
		  <input type="hidden" name="action" value="add">
		  <button type="submit" class="addButton">Add New Employee</button>
		</form>
	    <!-- <button  class="addButton">Add</button> -->
    </div>

</body>

</html>