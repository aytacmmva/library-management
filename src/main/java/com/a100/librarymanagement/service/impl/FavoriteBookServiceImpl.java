package com.a100.librarymanagement.service.impl;

import com.a100.librarymanagement.dto.FavoriteBookRequestDto;
import com.a100.librarymanagement.dto.FavoriteBookResponseDto;
import com.a100.librarymanagement.entity.FavoriteBook;
import com.a100.librarymanagement.exception.alreadyexist.FavoriteBookAlreadyExistsException;
import com.a100.librarymanagement.exception.notfound.FavoriteBookNotFoundException;
import com.a100.librarymanagement.mapper.FavoriteBookMapper;
import com.a100.librarymanagement.repository.FavoriteBookRepository;
import com.a100.librarymanagement.service.FavoriteBookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FavoriteBookServiceImpl implements FavoriteBookService {
    FavoriteBookRepository repository;


    @Override
    public FavoriteBookResponseDto addToFavorites(FavoriteBookRequestDto favoriteBookRequest) {
        Optional<FavoriteBook> favoriteBook = repository
                .findByBookIdAndUserId(favoriteBookRequest.getBookId(), favoriteBookRequest.getUserId());

        if (favoriteBook.isPresent()) {
            log.warn("This book already exists");
            throw new FavoriteBookAlreadyExistsException("Bu kitab artiq favorinizdedir,yeniden elave ede bilmezsiniz");
        }
        FavoriteBook entity = FavoriteBookMapper.toEntity(favoriteBookRequest);
        repository.save(entity);
        log.info("FavoritBook added successfully");

        return FavoriteBookMapper.toDto(entity);
    }

    @Override
    public List<FavoriteBookResponseDto> getAllByHistory() {
        List<FavoriteBook> list = repository.findAll();
        log.info("FavoritBook found successfully");
        return list.stream()
                .map(FavoriteBookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FavoriteBookResponseDto> getAllByUserId(Integer userId) {
        List<FavoriteBook> list = repository.findAllByUserIdOrderByCreatedDateDesc(userId);

        if (list.isEmpty()) {
            throw new FavoriteBookNotFoundException("Bu istifadəçi üçün bəyənilmiş məhsul tapılmadı.");
        }
        return list.stream()
                .map(FavoriteBookMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteFromFavorites(Integer id) {
        if (!repository.existsById(id)) {
            throw new FavoriteBookNotFoundException("Silinmək istənən favorit tapılmadı: ID = " + id);
        }
        repository.deleteById(id);
    }



}