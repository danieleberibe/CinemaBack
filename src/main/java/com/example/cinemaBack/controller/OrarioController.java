package com.example.cinemaBack.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.cinemaBack.model.Orario;
import com.example.cinemaBack.repository.OrarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrarioController {

    /** The JPA repository */
    @Autowired
    private OrarioRepository orarioRepository;

    @GetMapping("/orario")
    public ResponseEntity<List<Orario>> getAll(){
        try {
			List<Orario> orario = new ArrayList<Orario>();

			orarioRepository.findAll().forEach(orario::add);

			return new ResponseEntity<>(orario, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    
}
