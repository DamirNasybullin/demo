package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book create(String name, String author) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public List<Book> findByAuthor(String author) {return bookRepository.findByAuthor(author);
    }
    public List<Book> findByAuthorAndName (String author, String name) {return bookRepository.findByAuthorAndName(author,name);
    }

}
