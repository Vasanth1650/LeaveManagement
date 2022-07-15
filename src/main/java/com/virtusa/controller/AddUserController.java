package com.virtusa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.model.User;
import com.virtusa.service.CustomUserService;


@RequestMapping("/addnew")
@RestController
@CrossOrigin
public class AddUserController {
	
	@Autowired
	public CustomUserService customservice;
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) throws Exception {
		return customservice.addUser(user);
	}
	
	@GetMapping("/{id}")
	public User getting(@PathVariable int id) {
		return customservice.getById(id);
	}
	
	@GetMapping("/findby/{username}")
	public User getUserByName(@PathVariable String username) throws Exception{
		return customservice.getByUsername(username);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id) throws Exception{
		User users = customservice.getById(id);
		users.setUsername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setPhonenumber(user.getPhonenumber());
		User update = customservice.updateAdder(users);
		return ResponseEntity.ok(update);
	}

}
