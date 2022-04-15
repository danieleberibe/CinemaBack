package com.example.cinemaBack.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.cinemaBack.model.User;
import com.example.cinemaBack.repository.UserRepository;
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
public class UsersController {
    
	/** The JPA repository */
    @Autowired
    private UserRepository userRepository;
    
	@GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false)String nome){
        try {
			List<User> users = new ArrayList<User>();

			if (nome == null)
				userRepository.findAll().forEach(users::add);
			else
				userRepository.findByNome(nome).forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable("id")long id){
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        try{
            User _user = userRepository.save(new User(user.getNome(),user.getCognome(),user.getEmail(),user.getPassword(),user.getData_nascita()));
            return new ResponseEntity<>(_user,HttpStatus.CREATED);
        }catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setNome(user.getNome());
			_user.setCognome(user.getCognome());
			_user.setEmail(user.getEmail());
            _user.setPassword(user.getPassword());
            _user.setData_nascita(user.getData_nascita());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
   
}