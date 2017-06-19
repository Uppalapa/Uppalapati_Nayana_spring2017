package com.jobfair.beans;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1480701284453040057L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	
	@NotEmpty
	@Column
	private String username;
	
	@NotEmpty
	@Column
	private String pwd;
	
	@NotEmpty
	@Column
	private String name;
	
	@NotEmpty
	@Email
	@Column
	private String email;
	
	@NotEmpty
	@Column
	private String role;
	
	@NotEmpty
	@Column
	private String address;
	
	@NotEmpty
	@Size(min=10,max=10)
	@Column
	private String phone;
		
	@NotEmpty
	@Column
	private String myself;
	
	@Column
	private String status;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Job> postedJobs = new HashSet<Job>(0);
		
	public Set<Job> getPostedJobs() {
		return postedJobs;
	}

	public void setPostedJobs(Set<Job> postedJobs) {
		this.postedJobs = postedJobs;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMyself() {
		return myself;
	}

	public void setMyself(String myself) {
		this.myself = myself;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userid=").append(userid).append(", username=")
				.append(username).append(", pwd=").append(pwd)
				.append(", name=").append(name).append(", email=")
				.append(email).append(", role=").append(role)
				.append(", address=").append(address).append(", myself=")
				.append(myself)	.append("]");
		return builder.toString();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

		
}
