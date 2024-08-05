package com.example.task.controller;

import com.example.task.dto.customer.CreateCustomerRequestDto;
import com.example.task.dto.customer.CustomerDto;
import com.example.task.dto.customer.UpdateCustomerRequestDto;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.task.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto create(@RequestBody @Valid CreateCustomerRequestDto requestDto) {
        return customerService.save(requestDto);
    }

    @GetMapping
    public List<CustomerDto> getAll(Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public CustomerDto updateById(@PathVariable("id") Long id,
                              @RequestBody @Valid UpdateCustomerRequestDto requestDto) {
        return customerService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        customerService.delete(id);
    }
}
