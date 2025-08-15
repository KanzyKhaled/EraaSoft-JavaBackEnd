package com.spring.app.service;

import com.spring.app.dto.EmailDto;


import java.util.List;

public interface EmailService {
    //  Create
    EmailDto saveEmail(EmailDto emailDto);

    //  Update
    EmailDto updateEmail(EmailDto emailDto);

    //  Delete
    void deleteEmailById(Long id);

    // Read
    List<EmailDto> getAllEmails();
    List<EmailDto> getEmailsByName(String name);
    List<EmailDto> getEmailsByNames(List<String> names);
    List<EmailDto> getEmailsByContent(String content);


}
