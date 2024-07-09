package com.api.demo_jpa_data.controllers;

import com.api.demo_jpa_data.dtos.BookRecordDto;
import com.api.demo_jpa_data.models.BookModel;
import com.api.demo_jpa_data.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // http://localhost:8080/book/save
    @PostMapping("/save")
    public ResponseEntity<BookModel> saveBook(@RequestBody BookRecordDto bookRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecordDto));
    }

    // http://localhost:8080/book/all
    @GetMapping("/all")
    public ResponseEntity<List<BookModel>> getAllBook() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    // http://localhost:8080/book/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }
}
