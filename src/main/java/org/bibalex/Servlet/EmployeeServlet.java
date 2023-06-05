package org.bibalex.Servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.bibalex.Models.Department;
import org.bibalex.Models.Employee;
import org.bibalex.Models.Section;
import org.bibalex.DAO.EmployeeDAO;
import org.bibalex.DAO.ConnectDB;
import org.bibalex.DAO.DepartmentDAO;
import org.bibalex.DAO.SectionDAO;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public EmployeeServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
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
				insertEmployee(request, response);
				break;
			case "delete":
				deleteEmployee(request, response);
				break;
			case "edit":
				editForm(request, response);
				break;
			case "update":
				updateEmployee(request, response);
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
		List<Department> departments;
		try {
			departments = departmentDAO.getDepartment();
		    request.setAttribute("departments", departments); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/employees/addEmployee.jsp");
	    
	    dispatcher.forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dobString = request.getParameter("dob");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate;
		try {
		    utilDate = format.parse(dobString);
		} catch (Exception e) {
		    throw new RuntimeException("Invalid date format: " + dobString, e);
		}
		java.sql.Date dob = new java.sql.Date(utilDate.getTime());
		String email = request.getParameter("email");
		String departmentIdStr = request.getParameter("departmentId");
		int departmentId = Integer.parseInt(departmentIdStr);
		try {
			employeeDAO.addEmployee(firstName, lastName, dob, email,departmentId);			
		}catch (SQLIntegrityConstraintViolationException e) {
		    String errorMessage = "Email already existed!";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/employees/viewEmployees.jsp").forward(request, response);
		} catch (SQLException e) {
		    String errorMessage = "An error occurred while performing the operation. Please try again later.";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/employees/viewEmployees.jsp").forward(request, response);
		}

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/employees/viewEmployees.jsp");
	    
	    dispatcher.forward(request, response);
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int employeeid = Integer.parseInt( request.getParameter("employeeid") );
		employeeDAO.deleteEmployee(employeeid);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/employees/viewEmployees.jsp");
	    
	    dispatcher.forward(request, response);
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int employeeID = Integer.parseInt(request.getParameter("employeeid"));
		Employee employee = employeeDAO.getEmployee(employeeID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/employees/addEmployee.jsp");
		request.setAttribute("employee", employee);
		dispatcher.forward(request, response);

	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int employeeid = Integer.parseInt( request.getParameter("employeeid"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dobString = request.getParameter("dob");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate;
		try {
		    utilDate = format.parse(dobString);
		} catch (Exception e) {
		    throw new RuntimeException("Invalid date format: " + dobString, e);
		}
		java.sql.Date dob = new java.sql.Date(utilDate.getTime());
		String email = request.getParameter("email");
		String departmentIdStr = request.getParameter("departmentId");
		int departmentId = Integer.parseInt(departmentIdStr);
		try {
			employeeDAO.updateEmployee(firstName, lastName, dob, email,departmentId, employeeid);
		}catch (SQLIntegrityConstraintViolationException e) {
		    String errorMessage = "Email already existed!";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/employees/viewEmployees.jsp").forward(request, response);
		} catch (SQLException e) {
		    String errorMessage = "An error occurred while performing the operation. Please try again later.";
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("/JSP/employees/viewEmployees.jsp").forward(request, response);
		}


	    RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/employees/viewEmployees.jsp");
	    
	    dispatcher.forward(request, response);
	}

}