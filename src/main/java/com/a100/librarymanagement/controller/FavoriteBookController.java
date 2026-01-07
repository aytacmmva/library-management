package com.a100.librarymanagement.controller;

import com.a100.librarymanagement.dto.FavoriteBookRequest;
import com.a100.librarymanagement.dto.FavoriteBookResponse;
import com.a100.librarymanagement.entity.FavoriteBook;
import com.a100.librarymanagement.service.FavoriteBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteBookController {
    private final FavoriteBookService favoriteService;

    @PostMapping
    public ResponseEntity<FavoriteBookResponse> add(@RequestBody FavoriteBookRequest favoriteBookRequest) {
        return ResponseEntity.ok(favoriteService.addToFavorites(favoriteBookRequest));
    }

    @GetMapping("/history")
    public ResponseEntity<List<FavoriteBookResponse>> getHistory() {
        return ResponseEntity.ok(favoriteService.getAllByHistory());
    }
    @GetMapping("/by-user-id/{userId}")
    public List<FavoriteBookResponse> getAllByUserId(@PathVariable Integer userId) {
        return favoriteService.getAllByUserId(userId);
    }
    @DeleteMapping("/{id}")
    public void deleteFromFavorites(@PathVariable Integer id) {
        favoriteService.deleteFromFavorites(id);
    }
}