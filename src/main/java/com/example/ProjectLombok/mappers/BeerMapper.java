package com.example.ProjectLombok.mappers;

import com.example.ProjectLombok.entities.Beer;
import com.example.ProjectLombok.model.BeerDTO;

public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
