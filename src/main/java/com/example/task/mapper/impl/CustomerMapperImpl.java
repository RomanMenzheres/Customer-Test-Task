package com.example.task.mapper.impl;

import com.example.task.mapper.CustomerMapper;
import com.example.task.model.Customer;
import com.example.task.dto.customer.CreateCustomerRequestDto;
import com.example.task.dto.customer.CustomerDto;
import com.example.task.dto.customer.UpdateCustomerRequestDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toModel(CreateCustomerRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        return new Customer(
                requestDto.fullName(),
                requestDto.email(),
                requestDto.phone()
        );
    }

    @Override
    public CustomerDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerDto(
                customer.getId(),
                customer.getFullName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    @Override
    public void updateCustomerFromDto(UpdateCustomerRequestDto requestDto, Customer customer) {
        if (requestDto == null) {
            return;
        }

        if (requestDto.fullName() != null) {
            customer.setFullName(requestDto.fullName());
        }
        if (requestDto.phone() != null) {
            customer.setPhone(requestDto.phone());
        }
    }
}
