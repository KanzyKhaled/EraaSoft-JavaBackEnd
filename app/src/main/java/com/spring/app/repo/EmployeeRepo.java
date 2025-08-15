package com.spring.app.repo;

import com.spring.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByIdIn(List<Long> ids);
    List<Employee> findByNameIn(List<String> names);
    List<Employee> findByNameStartingWith(String prefix);
}
