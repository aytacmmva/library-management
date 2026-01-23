package com.a100.librarymanagement.service;

import com.a100.librarymanagement.dto.FavoriteBookRequestDto;
import com.a100.librarymanagement.dto.FavoriteBookResponseDto;

import java.util.List;

public interface FavoriteBookService {
    FavoriteBookResponseDto addToFavorites(FavoriteBookRequestDto favoriteBookRequest);

    List<FavoriteBookResponseDto> getAllByHistory();

    List<FavoriteBookResponseDto> getAllByUserId(Integer userId);

    void deleteFromFavorites(Integer id);


}