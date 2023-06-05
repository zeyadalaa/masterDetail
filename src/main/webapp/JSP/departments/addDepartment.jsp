<%@page import="org.bibalex.DAO.SectionDAO"%>
<%@ page import="org.bibalex.Models.Section" %>
<%@ page import="org.bibalex.Models.Department" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/addEmployee.css">
    <meta charset="UTF-8">
    <title>Add Department</title>
</head>
<body>
    <div class="AddDepartment">
	    <div class="container">
	    <%Department department = (Department) request.getAttribute("department"); %>
	        <%
					if(department != null) {
					%>
	        			<h1>Edit Department</h1>
		          	<%}else{ %>
	        			<h1>Add Department</h1>
		          <%} %>
	    
	        <form action="${pageContext.request.contextPath}/Department" method="POST" class="add-employee-form">
	
	            <label for="departmentName">Department:</label>
				<input type="hidden" name="departmentid" value="${department.id}">
	            <input type="text" name="departmentName" id="departmentName" value="${department.name}" required><br>
	
	            <label for="Section Id">Section Name </label>
	            <select class="dropdown" name="sectionId" id="sectionId" >
				<%
	        		SectionDAO sectionDAO = new SectionDAO();
	        		List<Section> sections = sectionDAO.getSection();

					for(int i = 0 ;i<sections.size();i++){
						if(department !=null && department.getSection() != null && department.getSection().getId() == sections.get(i).getId()){
	        		%>
					        <option selected="selected"  value="<%=sections.get(i).getId() %>" > <%=sections.get(i).getName()%>  </option>
				    <%}else{ %>
				    
					        <option value="<%=sections.get(i).getId() %>" > <%=sections.get(i).getName()%>  </option>
			        <%}} %>

				</select>
				<%
					if(department != null) {
				%>
				    <input type="hidden" name="action" value="update">
		            <input class="add" type="submit" value="Update department">
				<%}else{ %>
				    <input type="hidden" name="action" value="insert">
		            <input class="add" type="submit" value="Add department">
	            <%} %>
				
	        </form>
	    </div>
    </div>
</body>
</html>
