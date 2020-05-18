package com.techm.banking.user.registration.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.banking.user.registration.dto.LoginDto;
import com.techm.banking.user.registration.exception.ValidationException;
import com.techm.banking.user.registration.model.User;
import com.techm.banking.user.registration.service.UserRegistrationService;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegistrationService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> getRegistredUsers() {
		return new ResponseEntity<List<User>>(userRegistrationService.getRegistredUsers(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<User>> getRegistredUserByUserId(@PathVariable long id) {
		return new ResponseEntity<Optional<User>>(userRegistrationService.getRegistredUserByUserId(id), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<User> getRegistredUserByUserNameOrEmail(@RequestBody @Valid LoginDto login) {
		return new ResponseEntity<User>(userRegistrationService.getRegistredUserByUserNameOrEmail(login),
				HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<User> registerUser(@RequestBody @Valid User user) throws ValidationException, ParseException {
		return new ResponseEntity<User>(userRegistrationService.registerUser(user), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateRegisteredUser(@PathVariable long id, @RequestBody @Valid User user) throws ValidationException, ParseException {
		return new ResponseEntity<User>(userRegistrationService.updateRegisteredUser(id, user), HttpStatus.OK);
	}
}
