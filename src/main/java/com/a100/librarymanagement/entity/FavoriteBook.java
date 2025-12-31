package com.a100.librarymanagement.entity;

import com.a100.librarymanagement.enums.FavoriteBookStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "favoritebook")
public class FavoriteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    Integer favoritebookId;

    Integer userId;

    @Column(name = "created_date")
    LocalDateTime createdDate;

    @PrePersist
    void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    FavoriteBookStatus status;
}