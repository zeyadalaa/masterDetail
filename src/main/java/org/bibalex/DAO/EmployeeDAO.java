package org.bibalex.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bibalex.Models.Department;
import org.bibalex.Models.Employee;
import org.bibalex.Models.Section;

import java.sql.Date;


//Data Access Object

public class EmployeeDAO {


    public List<Employee> getEmployees() throws SQLException {
    	List<Employee> employee = new ArrayList<>();

        ConnectDB connection = new ConnectDB();
        String STP= "CALL getEmployees()";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
        statement =  connection1.prepareCall(STP);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int employeeId = resultSet.getInt("id");
            String employeeFirst_Name = resultSet.getString("first_name");
            String employeesLast_name = resultSet.getString("last_name");
            Date employeesDOB = resultSet.getDate("date_of_birth");
            String employeesEmail = resultSet.getString("email");
            int departmentID = resultSet.getInt("department_id");
            int sectionID = resultSet.getInt("section_id");
            String sectionName = resultSet.getString("section_name");
            String departmentName = resultSet.getString("department_name");
//
//            System.out.print( " connection aaa : "+  departmentName + " "+  sectionID + " " + employeeFirst_Name );
            Section section = new Section(sectionID,sectionName);
            Department department = new Department(departmentID,departmentName,0,section);
            employee.add(new Employee(employeeId, employeeFirst_Name, employeesLast_name,
                    employeesDOB, employeesEmail,departmentID, department));
        }

        statement.close();
        connection1.close();
        return employee;
    }
    
    public Employee getEmployee(int employeeID) throws SQLException {
    	Employee employee = null;
    	Department department;
    	Section section;
        ConnectDB connection = new ConnectDB();
        String STP= "CALL getEmployee(?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;

        statement =  connection1.prepareCall(STP);
        statement.setInt(1, employeeID);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int employeeId = resultSet.getInt("id");
            String employeeFirst_Name = resultSet.getString("first_name");
            String employeesLast_name = resultSet.getString("last_name");
            Date employeesDOB = resultSet.getDate("date_of_birth");
            String employeesEmail = resultSet.getString("email");
            int departmentID = resultSet.getInt("department_id");
            int sectionID = resultSet.getInt("section_id");
            String sectionName = resultSet.getString("section_name");
            String departmentName = resultSet.getString("department_name");
//
//            System.out.print( " connection aaa : "+  departmentName + " "+  sectionID + " " + employeeFirst_Name );
            section = new Section(sectionID,sectionName);
            department = new Department(departmentID,departmentName,0,section);
            employee = new Employee(employeeId, employeeFirst_Name, employeesLast_name,
                    employeesDOB, employeesEmail,departmentID, department);
        }

        statement.close();
        connection1.close();
        return employee;
    }
    
    public void addEmployee(String firstName,String lastName,Date date,String email,Integer departmentId) throws SQLException {
        ConnectDB connection = new ConnectDB();
        String STP= "CALL addEmployee(?,?,?,?,?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
    	statement = connection1.prepareCall(STP);    
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setDate(3, date);
        statement.setString(4, email);
        statement.setInt(5, departmentId);
        statement.executeUpdate();
        
        statement.close();
        connection1.close();
    }

    public void updateEmployee(String firstName, String lastName, Date date, String email, int departmentId, int employeeid) throws SQLException {
                    

        ConnectDB connection = new ConnectDB();
        String STP= "CALL updateEmployee(?,?,?,?,?,?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
    	statement = connection1.prepareCall(STP);    
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setDate(3, date);
        statement.setString(4, email);
        statement.setInt(5, departmentId);
        statement.setInt(6, employeeid);
        statement.executeUpdate();
        statement.close();
        connection1.close();
    }

    public void deleteEmployee(int employeeid) throws SQLException {

        ConnectDB connection = new ConnectDB();
        String STP= "CALL deleteEmployee(?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
    	statement = connection1.prepareCall(STP);    
        statement.setInt(1, employeeid);
        statement.executeUpdate();
        statement.close();
        connection1.close();
    }
    
}
