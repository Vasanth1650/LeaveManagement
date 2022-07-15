package com.virtusa.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.model.Employee;
import com.virtusa.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	Logger logger = LogManager.getLogger(CustomUserService.class);
	
	
	public Employee addingEmployee(Employee employee) throws Exception {
		
		Employee emp ;
		try {
			if(getByUserid(employee.getUserid()).isEmpty()) {
				emp = repository.save(employee);
			}else {
				throw new Exception("Catch me");
			}
		}catch(Exception e) {
			throw new Exception("Already User Found Try To Add In Existing");
		}
		
		return emp;
	}
	
	public Employee updateAdd(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> getByName(String name){
		return repository.findByName(name);
	}
	
	public List<Employee> getAllEmployee(){
		return repository.findAll();
	}
	
	public List<Employee> getByUserid(String userid){
		return repository.findByUserid(userid);
	}
	
	public Employee getById(int id) {
		Optional<Employee>employee = repository.findById(id);
		return (employee.get());
	}
	
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}
	
	public Employee updateEmployee(int id,Employee employee) {
		if(getById(employee.getId())==null) {
			return null;
		}
		return repository.save(employee);
	}

}
