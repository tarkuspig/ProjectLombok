package com.example.ProjectLombok.Repositories;

import com.example.ProjectLombok.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomer(){

        Customer savedCustomer = customerRepository.save(Customer.builder()
                .customerName("Bob Ombongo")
                .build());

        assertThat(savedCustomer.getCustomerName()).isNotNull();
        assertThat(savedCustomer.getId()).isNotNull();

    }

}