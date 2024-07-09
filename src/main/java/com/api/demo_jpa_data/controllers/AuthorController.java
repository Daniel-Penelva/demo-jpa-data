package com.api.demo_jpa_data.controllers;

import com.api.demo_jpa_data.dtos.AuthorRecordDto;
import com.api.demo_jpa_data.models.AuthorModel;
import com.api.demo_jpa_data.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // http://localhost:8080/author/save
    @PostMapping("/save")
    public ResponseEntity<AuthorModel> saveAuthor(@RequestBody AuthorRecordDto authorRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(authorRecordDto));
    }

    // http://localhost:8080/author/all
    @GetMapping("/all")
    public ResponseEntity<List<AuthorModel>> getAllAuthor() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthor());
    }
}
