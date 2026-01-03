package com.a100.librarymanagement.service.impl;

import com.a100.librarymanagement.dto.FavoriteBookRequest;
import com.a100.librarymanagement.dto.FavoriteBookResponse;
import com.a100.librarymanagement.entity.FavoriteBook;
import com.a100.librarymanagement.enums.FavoriteBookStatus;
import com.a100.librarymanagement.exception.notfound.FavoriteBookNotFoundException;
import com.a100.librarymanagement.mapper.FavoriteBookMapper;
import com.a100.librarymanagement.repository.FavoriteBookRepository;
import com.a100.librarymanagement.service.FavoriteBookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FavoriteBookServiceImpl implements FavoriteBookService {
    FavoriteBookRepository repository;
    FavoriteBookMapper mapper;

    @Override
    public FavoriteBookResponse addToFavorites(FavoriteBookRequest favoriteBookRequest) {
        Optional<FavoriteBook> favoriteBook = repository.findByBookIdAndUserId(favoriteBookRequest.getBookId));
        FavoriteBook favoritebook = new FavoriteBook();
        favoriteBook.setUserId(favoriteBookRequest.getUserId());
        favoriteBook.setBookId(favoriteBookRequest.getBookId());
        favoriteBook.setStatus(FavoriteBookStatus.ACTIVE);
        favoriteBook.setCreatedDate(LocalDateTime.now());

        repository.save(favoriteBook);
        return mapper.toDto(favoriteBook);
    }

    @Override
    public List<FavoriteBookResponse> getAllByHistory() {
        List<FavoriteBook> list = repository.findAll();
        return list.stream()
                .map(favoriteBook -> mapper.toDto(favoriteBook))
                .collect(Collectors.toList());
    }

    @Override
    public List<FavoriteBookResponse> getAllByUserId(Integer userId) {
        List<FavoriteBook> list = repository.findAllByUserIdOrderByCreatedDateDesc(userId);
        if (list.isEmpty()) {
            throw new FavoriteBookNotFoundException("Bu istifadəçi üçün bəyənilmiş məhsul tapılmadı.");
        }
        return list.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteFromFavorites(Integer id) {
        if (!repository.existsById(id)) {
            throw new FavoriteBookNotFoundException("Silinmək istənən favorit tapılmadı: ID = " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<FavoriteBook> getByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

}