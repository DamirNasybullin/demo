package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

//    @GetMapping
//    public List<Book> getBooks(@RequestParam(value = "author", required = false) String author) {
//       if (author != null) {
//            return bookRepository.findByAuthor(author);
//        }
//        return bookRepository.findAll();
//   }

    @GetMapping("/get")
    public List<Book> getBooks (@RequestParam(value = "author", required = false) String author, @RequestParam(value = "name", required = false) String name ) {
        if (author != null && name != null) {
            return bookRepository.findByAuthorAndName(author,name);
        }
        return bookRepository.findAll();
    }

    @Autowired
    private BookService bookService;

    @PostMapping("/post")

    public List<Book> setBooks(@RequestParam(value = "author", required = false) String author,@RequestParam(value = "name", required = false) String name) {
        if (author != null && name != null) {
            bookService.create(author, name);
            getBooks (author,name);
        }
        return bookRepository.findAll();
    }


}
