package com.example.ProjectLombok.bootstrap;

import com.example.ProjectLombok.Repositories.BeerRepository;
import com.example.ProjectLombok.Repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BootstrapDataTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp(){
        bootstrapData = new BootstrapData(beerRepository, customerRepository);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run();

        assertThat(beerRepository.count()).isOne();
        assertThat(customerRepository.count()).isEqualTo(1);

    }
}