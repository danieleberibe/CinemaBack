package com.example.cinemaBack.repository;

import com.example.cinemaBack.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;



public interface FilmRepository  extends JpaRepository<Film, Long> {
    List<Film> findByNome(String nome);
    Optional<Film> findById(long id);

}