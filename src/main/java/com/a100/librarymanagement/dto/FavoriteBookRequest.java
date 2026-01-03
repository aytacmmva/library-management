package com.a100.librarymanagement.dto;

import com.a100.librarymanagement.enums.FavoriteBookStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteBookRequest {

    Integer bookId;

    Integer userId;

    FavoriteBookStatus status;

}
