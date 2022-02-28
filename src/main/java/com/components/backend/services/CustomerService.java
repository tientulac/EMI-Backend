package com.components.backend.services;

import com.components.backend.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
