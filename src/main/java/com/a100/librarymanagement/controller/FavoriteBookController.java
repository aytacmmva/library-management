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

    @PostMapping("/add")
    public ResponseEntity<FavoriteBookResponse> add(@RequestBody FavoriteBookRequest favoriteBookRequest) {
        return ResponseEntity.ok(favoriteService.addToFavorites(favoriteBookRequest));
    }

    @GetMapping("/history")
    public ResponseEntity<List<FavoriteBookResponse>> getHistory() {
        return ResponseEntity.ok(favoriteService.getAllByHistory());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FavoriteBook>> getByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(favoriteService.getByUserId(userId));
    }
}