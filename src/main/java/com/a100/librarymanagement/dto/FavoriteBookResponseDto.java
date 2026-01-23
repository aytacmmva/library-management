package com.a100.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteBookResponseDto {
    @NotNull
    @NotEmpty
    @NotBlank
    Integer bookId;

    Integer userId;

    String status;

    String createdDate;
}