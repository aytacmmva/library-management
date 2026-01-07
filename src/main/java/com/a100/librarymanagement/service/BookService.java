package com.a100.librarymanagement.service;

import com.a100.librarymanagement.dto.BookDto;
import com.a100.librarymanagement.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    BookDto getById(Integer id);

    Page<BookDto> getAll(int page, int size);

    void deleteById(Integer id);

    void update(Integer id, BookDto book);

    void create(BookDto book);

    List<Book> getBooksFromLastTwoDays();

    List<Book> searchByName(String name);

}