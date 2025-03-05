package com.example.ProjectLombok.Repositories;

import com.example.ProjectLombok.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
