package com.components.backend.controllers;

import com.components.backend.models.Customer;
import com.components.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/customer") // router
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {
        List<Customer> listCustomer = customerService.findAll();
        return listCustomer;
    }
}
