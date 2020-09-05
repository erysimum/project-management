package com.jrp.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_seq")
	private long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	/*
	 * @ManyToOne(cascade=
	 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
	 * CascadeType.REFRESH},fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "project_id") Project theproject;
	 */
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	@JsonIgnore
	private List<Project> p; // project should be same as mapped by
	
	
	public Employee() {}
	
	
	
	/* this is for many to one from employee to project
	 * public Project getTheproject() { return theproject; }
	 * 
	 * 
	 * 
	 * public void setTheproject(Project theproject) { this.theproject = theproject;
	 * }
	 */

	

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public List<Project> getP() {
		return p;
	}



	public void setP(List<Project> p) {
		this.p = p;
	}



	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
