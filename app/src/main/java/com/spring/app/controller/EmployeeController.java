package com.spring.app.controller;

import com.spring.app.dto.EmployeeDto;
import com.spring.app.mapper.EmployeeMapper;
import com.spring.app.model.Employee;
import com.spring.app.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper mapper = EmployeeMapper.EMPLOYEE_MAPPER;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //  Create
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto dto) {
        Employee saved = service.saveEmployee(mapper.toEmployee(dto));
        return ResponseEntity.status(201).body(mapper.toEmployeeDto(saved));
    }

    //  Update
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto dto) {
        dto.setId(id);
        Employee updated = service.updateEmployee(mapper.toEmployee(dto));
        return ResponseEntity.ok(mapper.toEmployeeDto(updated));
    }

    // Remove
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    //  Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> result = mapper.toEmployeeDtoList(service.getAllEmployees());
        return ResponseEntity.ok(result);
    }

    //  Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Employee emp = service.getEmployeeById(id);
        return emp != null ? ResponseEntity.ok(mapper.toEmployeeDto(emp)) : ResponseEntity.notFound().build();
    }

    //  Get Employees by List of IDs
    @PostMapping("/by-ids")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByIds(@RequestBody List<Long> ids) {
        List<EmployeeDto> result = mapper.toEmployeeDtoList(service.getEmployeesByIds(ids));
        return ResponseEntity.ok(result);
    }

    //  Get Employees by List of Names
    @PostMapping("/by-names")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByNames(@RequestBody List<String> names) {
        List<EmployeeDto> result = mapper.toEmployeeDtoList(service.getEmployeesByNames(names));
        return ResponseEntity.ok(result);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

}

