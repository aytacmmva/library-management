package com.a100.librarymanagement.mapper;

import com.a100.librarymanagement.dto.FavoriteBookResponse;
import com.a100.librarymanagement.entity.FavoriteBook;
import org.springframework.stereotype.Component;


@Component
public class FavoriteBookMapper {

    public FavoriteBookResponse toDto(FavoriteBook entity) {
        FavoriteBookResponse dto = new FavoriteBookResponse();
        dto.setId(entity.getId());
        dto.setFavoritebookId(entity.getFavoritebookId());
        dto.setUserId(entity.getUserId());
        dto.setStatus(entity.getStatus().name());
        dto.setCreatedDate(entity.getCreatedDate().toString());
        return dto;
    }

}