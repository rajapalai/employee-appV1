package com.synechron.employee.controller.impl;

import com.synechron.employee.controller.EmployeeController;
import com.synechron.employee.dto.EmployeeDTO;
import com.synechron.employee.entity.Employee;
import com.synechron.employee.mapper.EmployeeMapper;
import com.synechron.employee.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/employee")
@RestController
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeControllerImpl(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.save(employee));
    }

    @Override
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findById(id).orElse(null);
        return employeeMapper.asDTO(employee);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
    }


    // delete employee object through post mapping
    @Override
    @PostMapping("/v3/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmployeeDTO deleteEmpByEmpId( @RequestBody EmployeeDTO employeeDTO,@PathVariable("id") Integer id) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.deleteByEmpId(id,employee));
    }

    @Override
    @GetMapping
    public List<EmployeeDTO> list() {
        return employeeMapper.asDTOList(employeeService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<EmployeeDTO> pageQuery(Pageable pageable) {
        Page<Employee> employeePage = employeeService.findAll(pageable);
        List<EmployeeDTO> dtoList = employeePage
                .stream()
                .map(employeeMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, employeePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public EmployeeDTO update(@Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable("id") Integer id) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.update(employee, id));
    }
}