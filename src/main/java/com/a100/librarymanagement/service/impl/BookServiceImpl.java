package com.a100.librarymanagement.service.impl;

import com.a100.librarymanagement.dto.BookDto;
import com.a100.librarymanagement.entity.Book;
import com.a100.librarymanagement.exception.notfound.BookNotFoundException;
import com.a100.librarymanagement.mapper.BookMapper;
import com.a100.librarymanagement.repository.BookRepository;
import com.a100.librarymanagement.service.BookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Override
    public BookDto getById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        return BookMapper.bookToBookDto(book);
    }

    @Override
    public Page<BookDto> getAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Book> bookPage = bookRepository.findAll(pageable);

        return bookPage.map(BookMapper::bookToBookDto);
    }

    @Override
    public void deleteById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(null);

        bookRepository.delete(book);
    }

    @Override
    public void update(Integer id, BookDto book) {
        Book foundBook = bookRepository.findById(id).orElseThrow(null);

        foundBook.setAuthor(book.getAuthor());
        foundBook.setTitle(book.getTitle());
        foundBook.setDiscount(book.getDiscount());
        foundBook.setPrice(book.getPrice());

        bookRepository.save(foundBook);
    }

    @Override
    public void create(BookDto bookDto) {
        Book book = BookMapper.bookDtoBook(bookDto);

        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooksFromLastTwoDays() {
        LocalDateTime twoDaysAgo = LocalDateTime.now().minusDays(2);
        System.out.println(twoDaysAgo);
        return bookRepository.findRecentBooks(twoDaysAgo);
    }

    @Override
    public List<Book> searchByName(String name) {
        return bookRepository.findByTitleContainingIgnoreCase(name);
    }

}