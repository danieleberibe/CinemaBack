package com.example.cinemaBack.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.cinemaBack.model.Film;
import com.example.cinemaBack.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class FilmsController {

    /** The JPA repository */
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/films")
    public ResponseEntity<List<Film>> getAllFilms(@RequestParam(required = false)String nome){
        try {
			List<Film> films = new ArrayList<Film>();

			if (nome == null)
				filmRepository.findAll().forEach(films::add);
			else
				filmRepository.findByNome(nome).forEach(films::add);

			if (films.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(films, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @GetMapping("/films/{id}")
    public ResponseEntity<Film> getFilms(@PathVariable("id")long id){
        Optional<Film> filmData = filmRepository.findById(id);

        if (filmData.isPresent()) {
            return new ResponseEntity<>(filmData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/films")
    public ResponseEntity<Film> createUser(@RequestBody Film film){
        try{
            Film _film = filmRepository.save(new Film(film.getNome(),film.getDescrizione(),film.getGenere(),film.getRegista(),film.getProduttore(),film.getDurata(),film.getImg(),film.getAttivo()));
            return new ResponseEntity<>(_film,HttpStatus.CREATED);
        }catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/films/{id}")
	public ResponseEntity<Film> updateUser(@PathVariable("id") long id, @RequestBody Film film) {
		Optional<Film> filmData = filmRepository.findById(id);

		if (filmData.isPresent()) {
			Film _film = filmData.get();
			_film.setNome(film.getNome());
			_film.setDescrizione(film.getDescrizione());
			_film.setGenere(film.getGenere());
            _film.setRegista(film.getRegista());
            _film.setProduttore(film.getProduttore());
            _film.setDurata(film.getDurata());
            _film.setImg(film.getImg());
            _film.setAttivo(film.getAttivo());
			return new ResponseEntity<>(filmRepository.save(_film), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @DeleteMapping("/films/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") long id){
		try{
			filmRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/films")
	public ResponseEntity<HttpStatus> deleteAllFilms(){
		try{
			filmRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
}

