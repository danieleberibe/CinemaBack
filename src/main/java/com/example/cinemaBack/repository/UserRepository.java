package com.example.cinemaBack.repository;

import com.example.cinemaBack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;



public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNome(String nome);
    Optional<User> findById(long id);
    
    
}
