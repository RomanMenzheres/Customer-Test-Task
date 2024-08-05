package com.example.task.repository;

import com.example.task.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customers WHERE email = :email", nativeQuery = true)
    Optional<Customer> findByEmail(@Param("email") String email);
}
