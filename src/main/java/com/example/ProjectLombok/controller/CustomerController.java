package com.example.ProjectLombok.controller;

import com.example.ProjectLombok.model.Customer;
import com.example.ProjectLombok.services.CustomerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController

public class CustomerController {

    public static final String CUSTOMER_PATH = "/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){
        customerService.patchCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //I did this without checking the tutorial.  It does work with the request body entered but this is not necessary
    //look at the beer example which shows there's no need for the @RequestBody annotation
    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID customerId){

        customerService.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus. NO_CONTENT);
    }

    private final CustomerService customerService;
    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateCustomerById(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){

        customerService.updateCustomerById( customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity handlePost(@RequestBody  Customer customer){

        Customer savedCustomer = customerService.saveNewCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", CUSTOMER_PATH + savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, value = CUSTOMER_PATH)
    public List<Customer> listCustomers(){
        return customerService.listCustomers();
    }

    @RequestMapping(value = CUSTOMER_PATH_ID, method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId){

        log.debug("Get Customer by Id - in controller");

        return customerService.getCustomerById(customerId).orElseThrow(NotFoundException::new);
    }

}
