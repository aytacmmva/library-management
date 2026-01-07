package com.a100.librarymanagement.mapper;

import com.a100.librarymanagement.dto.FavoriteBookRequest;
import com.a100.librarymanagement.dto.FavoriteBookResponse;
import com.a100.librarymanagement.entity.FavoriteBook;
import org.springframework.stereotype.Component;


@Component
public class FavoriteBookMapper {

    public static FavoriteBookResponse toDto(FavoriteBook entity) {
        FavoriteBookResponse dto = new FavoriteBookResponse();
        dto.setBookId(entity.getBookId());
        dto.setUserId(entity.getUserId());
        dto.setStatus(entity.getStatus().name());
        dto.setCreatedDate(entity.getCreatedDate().toString());
        return dto;
    }

    public static FavoriteBook toEntity(FavoriteBookRequest request) {
        FavoriteBook entity = new FavoriteBook();
        entity.setBookId(request.getBookId());
        entity.setUserId(request.getUserId());
        entity.setStatus(request.getStatus());

        return entity;
    }
}