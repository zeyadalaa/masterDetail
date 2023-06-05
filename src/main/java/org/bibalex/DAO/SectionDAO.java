package org.bibalex.DAO;
import org.bibalex.Models.*;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
import java.sql.Date;


//Data Access Object

public class SectionDAO {

    public void addSection(String sectionName) throws SQLException {

        ConnectDB connection = new ConnectDB();
        String STP= "CALL addSection(?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
        statement = connection1.prepareCall(STP);    
        statement.setString(1, sectionName);
        statement.executeUpdate();
        
        statement.close();
        connection1.close();
    }

    public List<Section> getSection() throws SQLException {
    	List<Section> sections = new ArrayList<>();

        ConnectDB connection = new ConnectDB();
        String STP= "CALL getSection()";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        
        statement = connection1.prepareCall(STP);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int sectionID = resultSet.getInt("id");
            String sectionName = resultSet.getString("name");
            sections.add(new Section(sectionID,sectionName));
        }

        statement.close();
        connection1.close();
        return sections;
    }

    public int getSectionId(String sectionName) throws SQLException {
    	
        ConnectDB connection = new ConnectDB();
        String STP= "CALL getSectionId(?)";
        Connection connection1 =connection.ConnectToDatabase();
        CallableStatement statement = null;
        int sectionId=0;
        
        statement = connection1.prepareCall(STP);
        statement.setString(1, sectionName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            sectionId = resultSet.getInt("id");
        }
        
        statement.close();
        connection1.close();
        return sectionId;
    }
}
