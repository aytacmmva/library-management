package com.a100.librarymanagement.mapper;

import com.a100.librarymanagement.dto.FavoriteBookRequestDto;
import com.a100.librarymanagement.dto.FavoriteBookResponseDto;
import com.a100.librarymanagement.entity.FavoriteBook;
import org.springframework.stereotype.Component;


@Component
public class FavoriteBookMapper {

    public static FavoriteBookResponseDto toDto(FavoriteBook entity) {
        FavoriteBookResponseDto dto = new FavoriteBookResponseDto();
        dto.setBookId(entity.getBookId());
        dto.setUserId(entity.getUserId());
        dto.setStatus(entity.getStatus().name());
        dto.setCreatedDate(entity.getCreatedDate().toString());
        return dto;
    }

    public static FavoriteBook toEntity(FavoriteBookRequestDto request) {
        FavoriteBook entity = new FavoriteBook();
        entity.setBookId(request.getBookId());
        entity.setUserId(request.getUserId());
        entity.setStatus(request.getStatus());

        return entity;
    }
}