package com.example.controller;

import com.example.entity.CustomerEntity;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired private CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<CustomerEntity> getUser() {
        return this.customerRepository.findAll();
    }

    @GetMapping("/customer/{firstName}")
    public CustomerEntity getUser(@PathVariable String firstName) {
        return this.customerRepository.findOneByFirstName(firstName);
    }

    @PostMapping("/customers")
    public ResponseEntity addUser(@RequestBody CustomerEntity customer) {
        try {
            this.customerRepository.save(customer);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
