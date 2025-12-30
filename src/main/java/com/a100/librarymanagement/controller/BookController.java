package com.a100.librarymanagement.controller;

import com.a100.librarymanagement.dto.BookDto;
import com.a100.librarymanagement.entity.Book;
import com.a100.librarymanagement.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String name) {
        return bookService.searchByName(name);
    }

    @GetMapping("/recent")
    public List<Book> getRecentBooks() {
        return bookService.getBooksFromLastTwoDays();
    }

    @GetMapping("/books/{id}")
    public BookDto getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("/books")
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @DeleteMapping("/books/{id}")
    public void deleteById(@PathVariable Integer id) {
        bookService.deleteById(id);
    }

    @PutMapping("/books/{id}")
    public void update(@PathVariable Integer id, @RequestBody BookDto book) {
        bookService.update(id, book);
    }

    @PostMapping("/books")
    public void create(@RequestBody BookDto book) {
        bookService.create(book);
    }
}