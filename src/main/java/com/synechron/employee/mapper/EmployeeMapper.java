package com.synechron.employee.mapper;

import com.synechron.employee.dto.EmployeeDTO;
import com.synechron.employee.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDTO> {
    @Override
    @Mapping(target = "employeeId", ignore = true)
    Employee asEntity(EmployeeDTO dto);
}