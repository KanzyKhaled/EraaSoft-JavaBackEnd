package com.eraasoft.spring.service.impl;
import com.eraasoft.spring.model.Employee;
import com.eraasoft.spring.repo.EmployeeRepo;
import com.eraasoft.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public List<Employee> getEmployeesByIds(List<Long> ids) {
        return repo.findByIdIn(ids);
    }

    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> saveEmployees(List<Employee> emps) {
        return repo.saveAll(emps);
    }

    public Employee updateEmployee(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> updateEmployees(List<Employee> emps) {
        return repo.saveAll(emps);
    }

    public void deleteAllEmployees() {
        repo.deleteAll();
    }

    public void deleteEmployeeById(Long id) {
        repo.deleteById(id);
    }

    public void deleteEmployeesByIds(List<Long> ids) {
        repo.deleteAllById(ids);
    }

    public List<Employee> searchEmployeesByName(String prefix) {
        return repo.findByNameStartingWith(prefix);
    }
}
