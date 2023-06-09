package org.bibalex.Servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
 * Servlet implementation class SectionServlet
 */
@WebServlet("/Section" )
public class SectionServlet extends HttpServlet {
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
				insertSection(request, response);
				break;
			case "delete":
				deleteSection(request, response);
				break;
			case "edit":
				editForm(request, response);
				break;
			case "update":
				updateSection(request, response);
				break;
			default:
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
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/sections/addSection.jsp");
	    
	    dispatcher.forward(request, response);
	}

	private void insertSection(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String sectionName = request.getParameter("SectionName");

		try {
			sectionDAO.addSection(sectionName);
		}catch (SQLIntegrityConstraintViolationException e) {
		    // Handle unique constraint violation
		    String errorMessage = "Section name already existed !";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/sections/viewSections.jsp").forward(request, response);
		} catch (SQLException e) {
		    // Handle other SQL exceptions
		    String errorMessage = "An error occurred while performing the operation. Please try again later.";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/sections/viewSections.jsp").forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/sections/viewSections.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void deleteSection(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int sectionid = Integer.parseInt( request.getParameter("sectionid") );
		sectionDAO.deleteSection(sectionid);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/sections/viewSections.jsp");
	    
	    dispatcher.forward(request, response);
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int sectionid = Integer.parseInt(request.getParameter("sectionid"));
		
		Section section = sectionDAO.getSectionById(sectionid);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/sections/addSection.jsp");
		request.setAttribute("section", section);
		dispatcher.forward(request, response);

	}

	private void updateSection(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String sectionID = request.getParameter("sectionid");
		int sectionId = Integer.parseInt(sectionID);
		String sectionName = request.getParameter("SectionName");
		try {
			sectionDAO.updateSection(sectionId,sectionName);
		}catch (SQLIntegrityConstraintViolationException e) {
		    // Handle unique constraint violation
		    String errorMessage = "Section name already existed !";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/sections/viewSections.jsp").forward(request, response);
		} catch (SQLException e) {
		    // Handle other SQL exceptions
		    String errorMessage = "An error occurred while performing the operation. Please try again later.";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/sections/viewSections.jsp").forward(request, response);
		}
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/sections/viewSections.jsp");
	    
	    dispatcher.forward(request, response);
	}
}
