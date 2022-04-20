package com.example.cinemaBack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.example.cinemaBack.model.User;
import com.example.cinemaBack.model.Ticket;
import com.example.cinemaBack.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TicketController {
    
	/** The JPA repository */
    @Autowired
    private TicketRepository ticketRepository;


    @GetMapping("/ticket")
    public ResponseEntity<List<Ticket>> getAll(){
        try {
			List<Ticket> ticket = new ArrayList<Ticket>();

			ticketRepository.findAll().forEach(ticket::add);

			return new ResponseEntity<>(ticket, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }


    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("id")long id){
        Optional<Ticket> ticketData = ticketRepository.findById(id);

        if (ticketData.isPresent()) {
            return new ResponseEntity<>(ticketData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ticket")
    public ResponseEntity<Ticket> createUser(@RequestBody Ticket ticket){
        try{
            Ticket _ticket = ticketRepository.save(new Ticket(ticket.getPosto(),ticket.getTariffa(),ticket.getIdOrario(),ticket.getIdUtente(),ticket.getIdSala()));
            return new ResponseEntity<>(_ticket,HttpStatus.CREATED);
        }catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }



}
