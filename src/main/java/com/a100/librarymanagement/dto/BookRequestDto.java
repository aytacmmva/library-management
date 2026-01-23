package com.a100.librarymanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequestDto {

    @NotNull
    @NotEmpty
    @NotBlank
    String title;

    String author;

    Double price;

    Double discount;

    String description;

    String language;

    String categoryName;

    String categoryId;
}