<%@page import="org.bibalex.Servlet.DepartmentServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ page import="org.bibalex.Models.Department" %>
<%@ page import="org.bibalex.DAO.EmployeeDAO" %>
<%@ page import="java.util.List" %>
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
	            <th>Department Name</th>
	            <th>Employee Numbers</th>
	            <th>Section Name</th>
	            <th>Actions</th>
	        </tr>
	        <%-- JSP code to retrieve and display data from the database --%>
	        <%
	            // Assuming you have a list of departments retrieved from the database
	            //List<department> departments = getdepartmentsFromDatabase();
	
	            //for (department department : departments) {
	        %>
	        
	        <c:forEach  items="${departments}" var="department">
		        <tr class="rows">
		           	<td><c:out /></td>
					<td><c:out  /></td>
					<td><c:out  /></td>
		            <%-- <td><a href="edit?id=<c:out  />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out />">Delete</a></td> --%>
								
		            <td>
		                <button>Delete</button>
		                <button>Update</button>
		            </td>
		        </tr>
			</c:forEach>
		        <tr class="rows">
		            <td>zeyad</td>
		            <td>zeyad</td>
		            <td>zeyad</td>
		            <td>
		                <button>Delete</button>
		                <button>Update</button>
		            </td>
		        </tr>
	    </table>
	    <form action="${pageContext.request.contextPath}/Department" method="POST">
		  <input type="hidden" name="action" value="add">
		  <button type="submit" class="addButton">Add New department</button>
		</form>
	    <!-- <button  class="addButton">Add</button> -->
    </div>

</body>

</html>