package com.synechron.employee.service;

import com.synechron.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GenericService<E, M> {
    E save(E entity);

    List<E> save(List<E> entities);

    void deleteById(M id);

    //new method
    E deleteByEmpId (M id, E entity);

    Optional<E> findById(M id);

    List<E> findAll();

    Page<E> findAll(Pageable pageable);

    E update(E entity, Integer id);
}