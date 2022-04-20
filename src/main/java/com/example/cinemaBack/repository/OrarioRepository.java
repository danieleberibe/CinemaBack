package com.example.cinemaBack.repository;

import java.util.List;

import com.example.cinemaBack.model.Orario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrarioRepository extends JpaRepository<Orario, Long> {
    
}
