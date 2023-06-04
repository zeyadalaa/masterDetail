package org.bibalex.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bibalex.Models.Department;
import org.bibalex.Models.Section;

import java.sql.Date;


//Data Access Object

public class DepartmentDAO {
	

    void addDepartment(String name, int sectionId) throws SQLException {

        ConnectDB connection = new ConnectDB();
        String STP= "CALL addDepartment(?,?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
        statement = connection1.prepareCall(STP);    
        statement.setString(1, name);
        statement.setInt(2, sectionId);
        statement.executeUpdate();
        statement.close();
        connection1.close();
    }
    
    public List<Department> getDepartment() throws SQLException {
    	List<Department> departments = new ArrayList<>();

        ConnectDB connection = new ConnectDB();
        String STP= "CALL getDepartment()";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
        statement = connection1.prepareCall(STP);
        ResultSet resultSet = statement.executeQuery();
        
        while (resultSet.next()) {
            int departmentID = resultSet.getInt("id");
            String departmentName = resultSet.getString("department_name");
            int employees_number = resultSet.getInt("employees_number");
            int sectionID = resultSet.getInt("section_id");
            String sectionName = resultSet.getString("section_name");
            
            Section section = new Section(sectionID,sectionName);
            departments.add(new Department(departmentID,departmentName,employees_number,section));
        }

        statement.close();
        connection1.close();
        return departments;
    }

    public int getDepartmentId(String name) throws SQLException {

        ConnectDB connection = new ConnectDB();
        String STP= "CALL getDepartmentId(?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
        statement = connection1.prepareCall(STP);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        int departmentId = 0;
        
        if (resultSet.next()) {
            departmentId = resultSet.getInt("id");
        }
        
        statement.close();
        connection1.close();
        return departmentId;
    }

}
