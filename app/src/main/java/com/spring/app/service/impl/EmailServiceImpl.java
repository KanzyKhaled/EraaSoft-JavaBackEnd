package com.spring.app.service.impl;

import com.spring.app.dto.EmailDto;
import com.spring.app.mapper.EmailMapper;
import com.spring.app.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.app.repo.EmailRepo;
import com.spring.app.service.EmailService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepo repository;
    private final EmailMapper mapper;

    @Autowired
    public EmailServiceImpl(EmailRepo repository, EmailMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Create
    @Override
    public EmailDto saveEmail(EmailDto emailDto) {
        Email email = mapper.toEmail(emailDto);
        Email saved = repository.save(email);
        return mapper.toEmailDto(saved);
    }

    // Update
    @Override
    public EmailDto updateEmail(EmailDto emailDto) {
        Email existing = repository.findById(emailDto.getId())
                .orElseThrow(() -> new RuntimeException("Email not found with ID: " + emailDto.getId()));
        existing.setName(emailDto.getName());
        existing.setContent(emailDto.getContent());
        Email updated = repository.save(existing);
        return mapper.toEmailDto(updated);
    }

    // Delete
    @Override
    public void deleteEmailById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Email not found with ID: " + id);
        }
        repository.deleteById(id);
    }

    // Read
    @Override
    public List<EmailDto> getAllEmails() {
        return repository.findAll().stream()
                .map(mapper::toEmailDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByName(String name) {
        return repository.findByName(name).stream()
                .map(mapper::toEmailDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByNames(List<String> names) {
        return repository.findByNameIn(names).stream()
                .map(mapper::toEmailDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByContent(String content) {
        return repository.findByContent(content).stream()
                .map(mapper::toEmailDto)
                .collect(Collectors.toList());
    }
}



