package com.example.task.mapper;

import com.example.task.dto.customer.CreateCustomerRequestDto;
import com.example.task.model.Customer;
import com.example.task.dto.customer.CustomerDto;
import com.example.task.dto.customer.UpdateCustomerRequestDto;


public interface CustomerMapper {
    Customer toModel(CreateCustomerRequestDto requestDto);

    CustomerDto toDto(Customer customer);

    void updateCustomerFromDto(UpdateCustomerRequestDto requestDto, Customer customer);
}
