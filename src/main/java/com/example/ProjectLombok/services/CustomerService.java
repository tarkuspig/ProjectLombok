package com.example.ProjectLombok.services;


import com.example.ProjectLombok.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



public interface CustomerService {
    List<CustomerDTO> listCustomers();

    Optional<CustomerDTO> getCustomerById(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

    void updateCustomerById(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomerById(UUID customerId);

    void patchCustomerById(UUID customerId, CustomerDTO customerDTO);
}
