package com.synechron.employee.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmployeeDTO {
    private Integer employeeId;

    // employee FirstName should not be empty or null
    // FirstName should have at least 6 to 10 characters
    @NotEmpty
    @Size(min = 3, message = "Please Enter Employee FirstName And FirstName Must Be at Least 3 to 10 characters")
    private String employeeFirstName;

    // employee LastName should not be empty or null
    // LastName should have at least 6 to 10 characters
    @NotEmpty
    @Size(min = 3, message = "Please Enter Employee LastName And LastName Must Be at Least 3 to 10 characters")
    private String employeeLastName;

    // employee Department should not be empty or null
    // Department should have at least 6 to 10 characters
    @NotEmpty
    @Size(min = 3, message = "Please Enter Department Name And Department Must Be at Least 3 to 10 characters")
    private String department;

    @DecimalMin(value = "1.0", message = "Please Enter a valid Salary Amount")
    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer employeeId, String employeeFirstName, String employeeLastName, String department, double salary) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.department = department;
        this.salary = salary;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeLastName() {
        return this.employeeLastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }
}