package com.a100.librarymanagement.mapper;

import com.a100.librarymanagement.dto.BookDto;
import com.a100.librarymanagement.entity.Book;

public class BookMapper {

    public static BookDto bookToBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());
        bookDto.setDiscount(book.getDiscount());
        bookDto.setPrice(book.getPrice());
        bookDto.setDescription(book.getDescription());

        return bookDto;
    }

    public static Book bookDtoBook(BookDto bookdto) {
        Book book = new Book();
        book.setAuthor(bookdto.getAuthor());
        book.setTitle(bookdto.getTitle());
        book.setDiscount(bookdto.getDiscount());
        book.setPrice(bookdto.getPrice());
        book.setDescription(bookdto.getDescription());

        return book;
    }
}