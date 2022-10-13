package com.synechron.employee.service.impl;

import com.synechron.employee.dao.EmployeeRepository;
import com.synechron.employee.entity.Employee;
import com.synechron.employee.exceptionHandling.ResourceNotFoundException;
import com.synechron.employee.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee save(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public List<Employee> save(List<Employee> entities) {
        return (List<Employee>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Employee", "employeeId", id);
        }
    }

    // delete employee object through post mapping
    @Override
    public Employee deleteByEmpId(Integer id, Employee entity) {
        try {
                repository.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("Employee", "employeeId", id);
        }
        return entity;
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeId", id)));
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        Page<Employee> entityPage = repository.findAll(pageable);
        List<Employee> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Employee update(Employee entity, Integer id) {
        Optional<Employee> optional = Optional.ofNullable(findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeId", id)));
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}