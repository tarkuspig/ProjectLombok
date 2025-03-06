package com.example.ProjectLombok.bootstrap;

import com.example.ProjectLombok.Repositories.BeerRepository;
import com.example.ProjectLombok.Repositories.CustomerRepository;
import com.example.ProjectLombok.entities.Beer;
import com.example.ProjectLombok.entities.Customer;
import com.example.ProjectLombok.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository  customerRepository;



    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();







    }

    private void loadCustomerData() {
        if(customerRepository.count() == 0) {
            Customer customer = Customer.builder()
                    .customerName("Big Jimmy")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

            customerRepository.save(customer);
        }
    }

    private void loadBeerData() {
        if(beerRepository.count()==0) {
            Beer beer = Beer.builder()
                    .beerName("Sol")
                    .beerStyle(BeerStyle.LAGER)
                    .price(new BigDecimal("2.50"))
                    .upc("1234567")
                    .quantityOnHand(60)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();
            beerRepository.save(beer);
        }
    }

}
