package com.spring.app.mapper;

import com.spring.app.dto.EmailDto;
import com.spring.app.dto.EmployeeDto;
import com.spring.app.model.Email;
import com.spring.app.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    EmailMapper EMAIL_MAPPER = Mappers.getMapper(EmailMapper.class);

    Email toEmail(EmailDto emailDto);
    EmailDto toEmailDto(Email email);

    List<Email> toEmailList(List<EmailDto> emailDtos);
    List<EmailDto> toEmailDtoList(List<Email> emails);
}
