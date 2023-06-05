<%@page import="org.bibalex.Servlet.DepartmentServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ page import="org.bibalex.Models.Department" %>
<%@ page import="org.bibalex.DAO.DepartmentDAO" %>
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
	        
		        <tr class="rows">
	        		<%
	        		DepartmentDAO departmentDAO = new DepartmentDAO();
	        		List<Department> departments = departmentDAO.getDepartment();
	        	
					for(int i = 0 ;i<departments.size();i++){
	        		%>
	        		   <tr class="rows">
	       			   <td><%out.println(departments.get(i).getName()); %></td>
	       			   <td><%out.println(departments.get(i).getEmployees_number()); %></td>
	       			   <td><%out.println(departments.get(i).getSection().getName()); %></td>
					   <td>
		       			   <div class="action-buttons">
			       			   <form action="${pageContext.request.contextPath}/Employee" method="POST">
								  <input type="hidden" name="action" value="update">
					                <button type="submit" class="updateButton">Update</button>
							   </form>
							   
			       			   <form action="${pageContext.request.contextPath}/Employee" method="POST">
								  <input type="hidden" name="action" value="delete">
				                	<button type="submit" class="deleteButton">Delete</button>
							   </form>
						   </div>
			            </td>
					<%}%>
		        </tr>
		        <!-- <tr class="rows">
		            <td>zeyad</td>
		            <td>zeyad</td>
		            <td>zeyad</td>
		            <td>
		                <button>Delete</button>
		                <button>Update</button>
		            </td>
		        </tr> -->
	    </table>
	    <form action="${pageContext.request.contextPath}/Department" method="POST">
		  <input type="hidden" name="action" value="add">
		  <button type="submit" class="addButton">Add New department</button>
		</form>
	    <!-- <button  class="addButton">Add</button> -->
    </div>

</body>

</html>