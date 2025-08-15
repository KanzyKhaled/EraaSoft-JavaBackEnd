package com.spring.app.service;

import com.spring.app.model.Employee;

import java.util.List;

public interface EmployeeService {
    //  Create
    Employee saveEmployee(Employee emp);
    List<Employee> saveEmployees(List<Employee> emps);

    //  Update
    Employee updateEmployee(Employee emp);
    List<Employee> updateEmployees(List<Employee> emps);

    //  Delete
    void deleteEmployeeById(Long id);
    void deleteEmployeesByIds(List<Long> ids);
    void deleteAllEmployees();

    // Read
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByIds(List<Long> ids);
    Employee getEmployeeById(Long id); // Optional convenience method
    List<Employee> getEmployeesByNames(List<String> names);

    // Search
    List<Employee> searchEmployeesByName(String prefix);
}

