package services;

import model.Beer;

import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BeerService {

    Beer getBeerById(UUID id);
}