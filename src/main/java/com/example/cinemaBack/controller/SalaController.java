package com.example.cinemaBack.controller;

import com.example.cinemaBack.repository.FilmRepository;
import com.example.cinemaBack.repository.SalaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.cinemaBack.model.Sala;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping("/sala")
    public ResponseEntity<List<Sala>> getAll(){
        try {
            List<Sala> sale = new ArrayList<Sala>();

            salaRepository.findAll().forEach(sale::add);

            return new ResponseEntity<>(sale, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sala/{id}")
    public ResponseEntity<Sala> getSala(@PathVariable("id")long id){
        Optional<Sala> salaData = salaRepository.findById(id);

        if (salaData.isPresent()) {
            return new ResponseEntity<>(salaData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}