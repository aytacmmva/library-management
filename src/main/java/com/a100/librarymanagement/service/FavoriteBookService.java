package com.a100.librarymanagement.service;

import com.a100.librarymanagement.dto.FavoriteBookResponse;
import com.a100.librarymanagement.entity.FavoriteBook;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FavoriteBookService {
    FavoriteBookResponse addToFavorites(Integer userId, Integer favoritebookId);

    List<FavoriteBookResponse> getAllByHistory();

    List<FavoriteBookResponse> getAllByUserId(Integer userId);

    void deleteFromFavorites(Integer id);

     List<FavoriteBook> getByUserId(Integer userId);
}