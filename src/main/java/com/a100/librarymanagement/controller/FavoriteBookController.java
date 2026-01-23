package com.a100.librarymanagement.controller;

import com.a100.librarymanagement.dto.FavoriteBookRequestDto;
import com.a100.librarymanagement.dto.FavoriteBookResponseDto;
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
    public ResponseEntity<FavoriteBookResponseDto> add(@RequestBody FavoriteBookRequestDto favoriteBookRequest) {
        return ResponseEntity.ok(favoriteService.addToFavorites(favoriteBookRequest));
    }

    @GetMapping("/history")
    public ResponseEntity<List<FavoriteBookResponseDto>> getHistory() {
        return ResponseEntity.ok(favoriteService.getAllByHistory());
    }
    @GetMapping("/by-user-id/{userId}")
    public List<FavoriteBookResponseDto> getAllByUserId(@PathVariable Integer userId) {
        return favoriteService.getAllByUserId(userId);
    }
    @DeleteMapping("/{id}")
    public void deleteFromFavorites(@PathVariable Integer id) {
        favoriteService.deleteFromFavorites(id);
    }
}