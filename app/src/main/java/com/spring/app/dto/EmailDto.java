package com.spring.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonInclude;

@Getter
@Setter
@NoArgsConstructor // default
@AllArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDto {

    private Long id;

    @NotBlank(message = "Name must not be null or empty")
    private String name;

    @Email(message = "Content must be a valid email format")
    private String content;
}
