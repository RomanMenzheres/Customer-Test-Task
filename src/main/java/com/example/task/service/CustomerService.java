package com.example.task.service;

import com.example.task.dto.customer.CreateCustomerRequestDto;
import com.example.task.dto.customer.CustomerDto;
import com.example.task.dto.customer.UpdateCustomerRequestDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CustomerService {
    CustomerDto save(CreateCustomerRequestDto requestDto);

    List<CustomerDto> findAll(Pageable pageable);

    CustomerDto findById(Long id);

    CustomerDto update(Long id, UpdateCustomerRequestDto requestDto);

    void delete(Long id);
}
