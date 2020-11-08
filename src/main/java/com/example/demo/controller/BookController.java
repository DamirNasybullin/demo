package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public List<Book> getBooks(@RequestParam(value = "author", required = false) String author) {
        if (author != null) {
            return bookRepository.findByAuthor(author);
        }
        return bookRepository.findAll();
    }
}
