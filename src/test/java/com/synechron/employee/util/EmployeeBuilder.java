package com.synechron.employee.util;

import com.synechron.employee.dto.EmployeeDTO;
import com.synechron.employee.entity.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeBuilder {
    public static List<EmployeeDTO> getListDTO() {
        return Arrays.asList(new EmployeeDTO(1,"Amarjeet","Palai","DEV",125000),
                new EmployeeDTO(2,"Raja","Palai","PROD",12000),
                new EmployeeDTO(3,"Manoj","Barisal","QA",25521),
                new EmployeeDTO(4,"Santosh","Sahoo","QC",50000));
    }

    public static List<Employee> getListEntities() {
        return Arrays.asList(new Employee(1,"Amarjeet","Palai","DEV",125000),
                new Employee(2,"Raja","Palai","PROD",12000),
                new Employee(3,"Manoj","Barisal","QA",25521),
                new Employee(4,"Santosh","Sahoo","QC",50000));
    }

    public static EmployeeDTO getDTO() {
        return new EmployeeDTO(1,"Amarjeet","Palai","DEV",125000);
    }

    public static Employee getEntity() {
        return new Employee(1,"Amarjeet","Palai","DEV",125000);
    }
}
