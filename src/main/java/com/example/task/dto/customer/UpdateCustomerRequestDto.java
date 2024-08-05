package com.example.task.dto.customer;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record UpdateCustomerRequestDto(
        @Length(min = 2, max = 50)
        String fullName,
        @Length(min = 6, max = 14)
        @Pattern(regexp = "\\+[0-9]+$")
        String phone
) {
}
