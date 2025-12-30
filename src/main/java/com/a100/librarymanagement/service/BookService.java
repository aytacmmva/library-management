package com.a100.librarymanagement.service;

import com.a100.librarymanagement.dto.BookDto;
import com.a100.librarymanagement.entity.Book;

import java.util.List;

public interface BookService {

    BookDto getById(Integer id);

    List<BookDto> getAll();

    void deleteById(Integer id);

    void update(Integer id, BookDto book);

    void create(BookDto book);

    List<Book> getBooksFromLastTwoDays();

    List<Book> searchByName(String name);

}