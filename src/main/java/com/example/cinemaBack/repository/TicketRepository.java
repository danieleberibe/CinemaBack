package com.example.cinemaBack.repository;

import java.util.List;
import java.util.Optional;
import com.example.cinemaBack.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

    Optional<Ticket> findById(long id);
    
}
