package com.klef.ep.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="faculty_table")
public class Faculty implements Serializable{
	@Id
	@Column(name="fid",nullable=false)
    private int id;
	
	@Column(name="fname" ,length=40,nullable=false)
    private String name;
	
	@Column(name="fgender",length=10,nullable=false)
    private String gender;
	
	@Column(name="fbranch",length=10,nullable=false)
    private String branch;
	
	@Column(name="fdob",length=20,nullable=false)
    private String dob;
	
	@Column(name="femail",length=80,nullable=false)
    private String email;
	
	@Column(name="fcontact",length=10,nullable=false)
    private String contact;
	
	@Column(name="fpassword", length=20,nullable=false)
	private String password;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
