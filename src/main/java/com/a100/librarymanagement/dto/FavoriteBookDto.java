package com.a100.librarymanagement.dto;

import com.a100.librarymanagement.enums.FavoriteBookStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FavoriteBookDto {

    Integer bookId;

    Integer userId;

    LocalDateTime createdDate;

    FavoriteBookStatus status;

}