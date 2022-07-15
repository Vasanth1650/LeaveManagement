package com.virtusa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.model.Employee;
import com.virtusa.service.EmployeeService;

@RequestMapping("/employee")
@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/getAllEmployee")
	public List<Employee> gettingListEmployee(){
		return service.getAllEmployee();
	}
	
	@GetMapping("/getById/{id}")
	public Employee gettingById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("/addEmployee")
	public Employee newEmployee(@RequestBody Employee employee) throws Exception {
		return service.addingEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public void deletingEmployee(@PathVariable int id) {
		service.deleteEmployeeById(id);
	}
	
	@GetMapping("/findByUserid/{userid}")
	public List<Employee> findByUserid(@PathVariable String userid){
		return service.getByUserid(userid);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updaterEmpoloyee(@PathVariable int id,@RequestBody Employee employee){
		Employee adddetails = service.getById(id);
		adddetails.setName(employee.getName());
		adddetails.setEmail(employee.getEmail());
		adddetails.setDateOfBirth(employee.getDateOfBirth());
		adddetails.setSupervisor(employee.getSupervisor());
		adddetails.setLeave(employee.getLeave());
		Employee update = service.updateAdd(adddetails);
		return ResponseEntity.ok(update);
	}

}
