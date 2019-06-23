package com.example.repository;

import com.example.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findOneByFirstName(String firstName);
}