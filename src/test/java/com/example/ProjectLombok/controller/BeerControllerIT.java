package com.example.ProjectLombok.controller;

import com.example.ProjectLombok.Repositories.BeerRepository;
import com.example.ProjectLombok.model.BeerDTO;
import com.example.ProjectLombok.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerIT {

    @Autowired
    BeerController beerController;

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testListBeers(){
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(1);
    }

    @Rollback
    @Transactional
    @Test
    void testEmptyList(){
        beerRepository.deleteAll();
        List<BeerDTO> dtos = beerController.listBeers();

        assertThat(dtos.size()).isEqualTo(0);


    }

    @Test
    void testGetById(){
        Beer beer = beerRepository.findAll().get(0);

        BeerDTO dto = beerController.getBeerById(beer.getId());

        assertThat(dto).isNotNull();
    }

    @Test
    void testBeerIdNotFound(){
        assertThrows(NotFoundException.class, () -> {
            beerController.getBeerById((UUID.randomUUID()));
        });

    }

    @Rollback
    @Transactional
    @Test
    void testSaveNewBeer(){
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("Skol")
                .build();

        ResponseEntity responseEntity = beerController.handlePost(beerDTO);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        System.out.println(Arrays.toString(locationUUID));

        UUID savedUUID = UUID.fromString(locationUUID[locationUUID.length -1]);


        Beer beer = beerRepository.findById(savedUUID).get();
        assertThat(beer).isNotNull();

    }

}