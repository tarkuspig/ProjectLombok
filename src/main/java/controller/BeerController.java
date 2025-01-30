package controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Beer;
import org.springframework.stereotype.Controller;
import services.BeerService;

import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id){

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(id);
    }

}