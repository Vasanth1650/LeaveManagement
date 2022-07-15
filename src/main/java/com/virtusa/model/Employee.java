package com.virtusa.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String email;
	
	private String userid;
	
	private String supervisor;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date dateOfBirth;
	
	
	
	@OneToMany(targetEntity = LeaveType.class,cascade = CascadeType.ALL)
	@JoinColumn(name="leave_id",referencedColumnName = "id")
	private List<LeaveType> leave;


	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	



	public List<LeaveType> getLeave() {
		return leave;
	}



	public void setLeave(List<LeaveType> leave) {
		this.leave = leave;
	}



	public Employee() {
		super();
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSupervisor() {
		return supervisor;
	}



	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	
	

	
	
	
	
	
	
	
	
	 
	
}