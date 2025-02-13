package org.jsp.College_Directory_Application.controller;

import org.jsp.College_Directory_Application.dto.AuthCred;
import org.jsp.College_Directory_Application.entity.User;
import org.jsp.College_Directory_Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable int id){
		return service.findUserById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllUsers(){
		return service.findAllUsers();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> findByUsernameAndPassword(@RequestBody AuthCred authCred){
		return service.findByUsernameAndPassword(authCred);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByUserId(@PathVariable int id){
		return service.deleteByUserId(id);
	}
	
}
