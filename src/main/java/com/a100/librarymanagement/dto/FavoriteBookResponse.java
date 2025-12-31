package com.a100.librarymanagement.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteBookResponse {
    Integer id;

    Integer favoritebookId;

    Integer userId;

    String status;

    String createdDate;
}