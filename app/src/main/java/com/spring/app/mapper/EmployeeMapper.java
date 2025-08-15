package com.spring.app.mapper;

import com.spring.app.dto.EmployeeDto;
import com.spring.app.model.Employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper(componentModel = "spring", uses = {EmailMapper.class})

public interface EmployeeMapper {
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);

    List<Employee> toEmployeeList(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> toEmployeeDtoList(List<Employee> employees);
}
