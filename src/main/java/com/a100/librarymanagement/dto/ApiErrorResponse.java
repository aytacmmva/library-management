package com.a100.librarymanagement.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiErrorResponse {

    int status;

    String message;

    String path;

    LocalDateTime timestamp;

    public ApiErrorResponse(String message, LocalDateTime now) {
    }
}