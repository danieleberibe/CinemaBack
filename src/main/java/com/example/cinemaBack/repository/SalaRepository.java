package com.example.cinemaBack.repository;

import java.util.List;
import java.util.Optional;

import com.example.cinemaBack.model.Sala;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long>{
    Optional<Sala> findById(long id);

}