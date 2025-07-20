package com.eraasoft.spring.service;

import com.eraasoft.spring.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByIds(List<Long> ids);
    Employee saveEmployee(Employee emp);
    List<Employee> saveEmployees(List<Employee> emps);
    Employee updateEmployee(Employee emp);
    List<Employee> updateEmployees(List<Employee> emps);
    void deleteAllEmployees();
    void deleteEmployeeById(Long id);
    void deleteEmployeesByIds(List<Long> ids);
    List<Employee> searchEmployeesByName(String prefix);
}