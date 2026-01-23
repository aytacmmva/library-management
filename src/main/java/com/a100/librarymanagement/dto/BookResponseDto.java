package com.a100.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDto {

    @NotNull
    @NotEmpty
    @NotBlank
    Integer id;

    @NotBlank
    String title;

    String author;

    @Positive
    Double price;

    Double discount;

    String description;

    String language;

    String categoryName;

    String categoryId;

    LocalDateTime createdAt;

}