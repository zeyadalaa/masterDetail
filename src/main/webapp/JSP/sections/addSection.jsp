<%@page import="org.bibalex.Models.Section"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/addEmployee.css">
    <meta charset="UTF-8">
    <title>Add Section</title>
    <script>
        function showError(message) {
            alert(message); // Replace with your preferred pop-up mechanism
        }
    </script>
</head>
<body>
    <div class="container-nav">
        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/JSP/employees/viewEmployees.jsp">Employee</a></li>
                <li><a href="${pageContext.request.contextPath}/JSP/departments/viewDepartments.jsp">Department</a></li>
                <li><a href="${pageContext.request.contextPath}/JSP/sections/viewSections.jsp">Section</a></li>
            </ul>
        </nav>
    </div>
    <div class="AddSection">
	    <div class="container">
	    <% if (request.getAttribute("errorMessage") != null) { %>
        <script>
            showError("<%= request.getAttribute("errorMessage") %>");
        </script>
    	<% } %>
	    
	    <%Section section = (Section) request.getAttribute("section"); %>
	        <%
					if(section != null) {
					%>
	        			<h1>Edit Section</h1>
		          	<%}else{ %>
	        			<h1>Add Section</h1>
		          <%} %>
	        <form action="Section" method="POST" class="add-employee-form">
	
	            <label for="SectionName">Section Name:</label>
				<input type="hidden" name="sectionid" value="${section.id}">
	            <input type="text" name="SectionName" id="SectionName"  value="${section.name}" required><br>
	
	
				<%
					if(section != null) {
				%>
				    <input type="hidden" name="action" value="update">
		            <input class="add" type="submit" value="Update section">
				<%}else{ %>
				    <input type="hidden" name="action" value="insert">
		            <input class="add" type="submit" value="Add section">
	            <%} %>
				
	        </form>
	    </div>
    </div>
</body>
</html>
