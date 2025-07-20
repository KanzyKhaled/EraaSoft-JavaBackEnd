package com.eraasoft.spring.controller;

import com.eraasoft.spring.model.Employee;
import com.eraasoft.spring.model.EraaSoftSchool;
import com.eraasoft.spring.service.EmployeeService;
import com.eraasoft.spring.service.EraaSoftSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @PostMapping("/by-ids")
    public List<Employee> getByIds(@RequestBody List<Long> ids) {
        return service.getEmployeesByIds(ids);
    }

    @PostMapping
    public Employee save(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    @PostMapping("/batch")
    public List<Employee> saveList(@RequestBody List<Employee> emps) {
        return service.saveEmployees(emps);
    }

    @PutMapping
    public Employee update(@RequestBody Employee emp) {
        return service.updateEmployee(emp);
    }

    @PutMapping("/batch")
    public List<Employee> updateList(@RequestBody List<Employee> emps) {
        return service.updateEmployees(emps);
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAllEmployees();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteEmployeeById(id);
    }

    @PostMapping("/delete-by-ids")
    public void deleteByIds(@RequestBody List<Long> ids) {
        service.deleteEmployeesByIds(ids);
    }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam String namePrefix) {
        return service.searchEmployeesByName(namePrefix);
    }
}