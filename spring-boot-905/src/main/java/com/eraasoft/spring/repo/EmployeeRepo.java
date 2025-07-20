package com.eraasoft.spring.repo;

import com.eraasoft.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByNameStartingWith(String prefix);
    List<Employee> findByIdIn(List<Long> ids);
}
