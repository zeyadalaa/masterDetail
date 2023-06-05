package org.bibalex.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


import org.bibalex.DAO.DepartmentDAO;
import org.bibalex.DAO.EmployeeDAO;
import org.bibalex.DAO.SectionDAO;
import org.bibalex.Models.Department;
import org.bibalex.Models.Employee;
import org.bibalex.Models.Section;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet( "/Department" )
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private EmployeeDAO employeeDAO;
	private DepartmentDAO departmentDAO;
	private SectionDAO sectionDAO ;
	
	public void init() {
		employeeDAO = new EmployeeDAO();
		departmentDAO = new DepartmentDAO();
		sectionDAO = new SectionDAO();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") ;
		if(action.isEmpty()) action = "home";
		
		System.out.println(action.isEmpty()+" "+ action + " ssssssssssssssss");
		try {
			switch (action) {
			case "add":
				showNewForm(request, response);
				break;
			case "insert":
				insertDepartment(request, response);
				break;
			case "delete":
				deleteDepartment(request, response);
				break;
			case "edit":
				editForm(request, response);
				break;
			case "update":
				updateDepartment(request, response);
				break;
			default:
				System.out.print( "/n view");
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Section> sections;
		try {
			sections = sectionDAO.getSection();
		    request.setAttribute("sections", sections); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/departments/addDepartment.jsp");
	    
	    dispatcher.forward(request, response);
	}

	private void insertDepartment(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String departmentName = request.getParameter("departmentName");
		String departmentIdStr = request.getParameter("sectionId");
		int departmentId = Integer.parseInt(departmentIdStr);

		departmentDAO.addDepartment(departmentName, departmentId);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/departments/viewDepartments.jsp");
	    
	    dispatcher.forward(request, response);
	}
	
	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int departmentid = Integer.parseInt( request.getParameter("departmentid") );
		departmentDAO.deleteDepartment(departmentid);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/departments/viewDepartments.jsp");
	    
	    dispatcher.forward(request, response);
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int departmentID = Integer.parseInt(request.getParameter("departmentid"));
		Department department = departmentDAO.getDepartmentByID(departmentID);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/departments/addDepartment.jsp");
		request.setAttribute("department", department);
		dispatcher.forward(request, response);

	}

	private void updateDepartment(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int departmentId = Integer.parseInt( request.getParameter("departmentid"));
		String departmentName = request.getParameter("departmentName");
		String sectionID = request.getParameter("sectionId");
		int sectionId = Integer.parseInt(sectionID);
	
		departmentDAO.updateDepartment(departmentId,sectionId,departmentName);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/departments/viewDepartments.jsp");
	    
	    dispatcher.forward(request, response);
	}
}
