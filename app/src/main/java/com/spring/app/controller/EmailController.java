package com.spring.app.controller;

import com.spring.app.dto.EmailDto;
import com.spring.app.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    private final EmailService service;


    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmailDto> create(@Valid @RequestBody EmailDto emailDto){
        EmailDto saved = service.saveEmail(emailDto);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping
    public ResponseEntity<EmailDto> createEmail(@Valid @RequestBody EmailDto emailDto){
        EmailDto saved = service.saveEmail(emailDto);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailDto> updateEmail(@PathVariable Long id, @Valid @RequestBody EmailDto dto) {
        dto.setId(id);
        EmailDto updated = service.updateEmail(dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        service.deleteEmailById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmailDto>> getAllEmails() {
        return ResponseEntity.ok(service.getAllEmails());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<EmailDto>> getEmailsByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getEmailsByName(name));
    }

    @PostMapping("/by-names")
    public ResponseEntity<List<EmailDto>> getEmailsByNames(@RequestBody List<String> names) {
        return ResponseEntity.ok(service.getEmailsByNames(names));
    }

    @GetMapping("/by-content/{content}")
    public ResponseEntity<List<EmailDto>> getEmailsByContent(@PathVariable String content) {
        return ResponseEntity.ok(service.getEmailsByContent(content));
    }




}
