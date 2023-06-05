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
                <li><a href="${pageContext.request.contextPath}/JSP/employees/viewEmployees.jsp">Employee</a></li>
                <li><a href="${pageContext.request.contextPath}/JSP/departments/viewDepartments.jsp">Department</a></li>
                <li><a href="${pageContext.request.contextPath}/JSP/sections/viewSections.jsp">Section</a></li>
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
	        

      			<tr class="rows">
<%
	        		SectionDAO sectionDAO = new SectionDAO();
	        		List<Section> sections = sectionDAO.getSection();
	        	
					for(int i = 0 ;i<sections.size();i++){
	        		%>
	        		   <tr class="rows">
	       			   <td><%out.println(sections.get(i).getName()); %></td>
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
	            <!-- <td>zeyad</td>
	            <td>
	                <button>Delete</button>
	                <button>Update</button>
	            </td> -->
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