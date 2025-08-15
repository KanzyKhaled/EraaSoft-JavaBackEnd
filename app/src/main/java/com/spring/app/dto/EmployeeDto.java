package com.spring.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor // default
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private Long id;
    @NotBlank(message = "Name must not be null or empty")
    private String name;

    @Min(value = 16, message = "Age must be greater than 15")
    @Max(value = 39, message = "Age must be less than 40")
    private int age;

    @DecimalMin(value = "5001", message = "Salary must be greater than 5000")
    @DecimalMax(value = "9999", message = "Salary must be less than 10000")
    private double salary;

    private List<EmailDto> emails;




}
