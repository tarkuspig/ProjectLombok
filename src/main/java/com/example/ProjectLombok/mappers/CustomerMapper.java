package com.example.ProjectLombok.mappers;

import com.example.ProjectLombok.entities.Customer;
import com.example.ProjectLombok.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
