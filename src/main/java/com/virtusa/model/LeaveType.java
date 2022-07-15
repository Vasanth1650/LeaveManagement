package com.virtusa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="leavetype")
public class LeaveType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaverequestid;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date endDate;
	
	private int days;
	
	private String type;
	
	private String status;

	public int getLeaverequestid() {
		return leaverequestid;
	}

	public void setLeaverequestid(int leaverequestid) {
		this.leaverequestid = leaverequestid;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

	
	
	

}
