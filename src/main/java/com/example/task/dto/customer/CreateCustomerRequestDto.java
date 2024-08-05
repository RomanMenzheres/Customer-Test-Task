package com.example.task.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CreateCustomerRequestDto(
        @NotBlank
        @Length(min = 2, max = 50)
        String fullName,
        @NotBlank
        @Length(min = 2, max = 100)
        @Email
        String email,
        @Length(min = 6, max = 14)
        @Pattern(regexp = "\\+[0-9]+$")
        String phone
) {
}
