<%@page import="org.bibalex.Models.Section"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/addEmployee.css">
    <meta charset="UTF-8">
    <title>Add Section</title>
</head>
<body>
    <div class="AddSection">
	    <div class="container">
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
