package com.a100.librarymanagement.repository;

import com.a100.librarymanagement.entity.FavoriteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Integer> {

    Optional<FavoriteBook> findById(Integer id);

    List<FavoriteBook> findAllByUserIdOrderByCreatedDateDesc(Integer userId);

    List<FavoriteBook> findAllByOrderByCreatedDateDesc();

    List<FavoriteBook> findByUserId(Integer userId);
}