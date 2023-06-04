package org.bibalex.Models;



import java.sql.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date DOB;
    private String email;
    private int departmentID;
    private Department department;

    public Employee(int id, String firstName, String lastName, Date DOB, String email,int departmentID, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.email = email;
        this.departmentID = departmentID;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return DOB
;    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
}