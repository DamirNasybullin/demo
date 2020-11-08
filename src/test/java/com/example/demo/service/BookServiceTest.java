package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;


    @Test
    void test() {
        bookRepository.deleteAll();
        bookService.create("name1", "a1");
        bookService.create("name2", "a1");
        bookService.create("name3", "a1");
        bookService.create("name4", "a2");
        bookService.create("name5", "a3");
        List<Book> all = bookRepository.findAll();
        assertEquals(5, all.size());

        List<Book> a1 = bookService.findByAuthor("a1");
        assertEquals(3, a1.size());
    }


}