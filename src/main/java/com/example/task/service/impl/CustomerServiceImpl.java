package com.example.task.service.impl;

import com.example.task.exception.RegistrationException;
import com.example.task.dto.customer.CreateCustomerRequestDto;
import com.example.task.dto.customer.CustomerDto;
import com.example.task.dto.customer.UpdateCustomerRequestDto;
import com.example.task.exception.EntityNotFoundException;
import com.example.task.mapper.CustomerMapper;
import com.example.task.model.Customer;
import com.example.task.repository.CustomerRepository;
import com.example.task.service.CustomerService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto save(CreateCustomerRequestDto requestDto) {
        if (customerRepository.findByEmail(requestDto.email()).isPresent()) {
            throw new RegistrationException("Provided email is already taken");
        }
        Customer customer = customerMapper.toModel(requestDto);
        customer.setCreated(LocalDateTime.now());
        customer.setUpdated(LocalDateTime.now());
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public List<CustomerDto> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable).stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto findById(Long id) {
        return customerMapper.toDto(customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find customer by id: " + id)));
    }

    @Override
    public CustomerDto update(Long id, UpdateCustomerRequestDto requestDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find customer by id: " + id));
        customerMapper.updateCustomerFromDto(requestDto, customer);
        customer.setUpdated(LocalDateTime.now());
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
