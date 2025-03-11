package com.example.ProjectLombok.controller;

import com.example.ProjectLombok.Repositories.CustomerRepository;
import com.example.ProjectLombok.entities.Customer;
import com.example.ProjectLombok.model.BeerDTO;
import com.example.ProjectLombok.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerControllerIT {

    @Autowired
    CustomerController customerController;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testListCustomers(){
        List<CustomerDTO> customerDTOS = customerController.listCustomers();
        System.out.println(customerController.listCustomers());

        assertThat(customerDTOS.size()).isEqualTo(1);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyListCustomers(){
        customerRepository.deleteAll();
        List<CustomerDTO> customerDTOS = customerController.listCustomers();

        assertThat(customerDTOS.size()).isEqualTo(0);

    }
    @Test
    void testGetCustomerById(){
        Customer customer = customerRepository.findAll().get(0);

        CustomerDTO dto = customerController.getCustomerById(customer.getId());

        assertThat(dto).isNotNull();

    }

    @Test
    void testGetCustomerByWrongId(){

        assertThrows(NotFoundException.class, () -> {
            customerController.getCustomerById(UUID.randomUUID());
        });

    }
}
