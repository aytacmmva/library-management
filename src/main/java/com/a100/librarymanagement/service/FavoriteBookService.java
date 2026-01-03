package com.a100.librarymanagement.service;

import com.a100.librarymanagement.dto.FavoriteBookRequest;
import com.a100.librarymanagement.dto.FavoriteBookResponse;
import com.a100.librarymanagement.entity.FavoriteBook;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FavoriteBookService {
    FavoriteBookResponse addToFavorites( FavoriteBookRequest favoriteBookRequest);

    List<FavoriteBookResponse> getAllByHistory();

    List<FavoriteBookResponse> getAllByUserId(Integer userId);

    void deleteFromFavorites(Integer id);

     List<FavoriteBook> getByUserId(Integer userId);
}