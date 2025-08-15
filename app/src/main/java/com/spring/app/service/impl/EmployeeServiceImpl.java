package com.spring.app.service.impl;

import com.spring.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.app.repo.EmployeeRepo;
import com.spring.app.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    //  Create
    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }

    @Override
    public List<Employee> saveEmployees(List<Employee> emps) {
        return employeeRepo.saveAll(emps);
    }

    //  Update
    @Override
    public Employee updateEmployee(Employee emp) {
        return employeeRepo.save(emp);
    }

    @Override
    public List<Employee> updateEmployees(List<Employee> emps) {
        return employeeRepo.saveAll(emps);
    }

    // Delete
    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void deleteEmployeesByIds(List<Long> ids) {
        List<Employee> toDelete = employeeRepo.findByIdIn(ids);
        employeeRepo.deleteAll(toDelete);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }

    //  Read
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeesByIds(List<Long> ids) {
        return employeeRepo.findByIdIn(ids);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        return emp.orElse(null);
    }

    @Override
    public List<Employee> getEmployeesByNames(List<String> names) {
        return employeeRepo.findByNameIn(names);
    }

    //  Search
    @Override
    public List<Employee> searchEmployeesByName(String prefix) {
        return employeeRepo.findByNameStartingWith(prefix);
    }
}

