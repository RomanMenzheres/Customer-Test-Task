package com.example.task.dto.customer;

public record CustomerDto(
        Long id,
        String fullName,
        String email,
        String phone
) {
}
