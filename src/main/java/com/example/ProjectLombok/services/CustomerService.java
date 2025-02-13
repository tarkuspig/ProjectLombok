package com.example.ProjectLombok.services;


import com.example.ProjectLombok.model.Customer;

import java.util.List;
import java.util.UUID;



public interface CustomerService {
    List<Customer> listCustomers();

    Customer getCustomerById(UUID id);
}
