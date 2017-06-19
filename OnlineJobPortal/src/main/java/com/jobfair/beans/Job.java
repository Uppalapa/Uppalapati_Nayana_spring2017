package com.jobfair.beans;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "jobs")
public class Job implements Serializable {
	
	
	private static final long serialVersionUID = -8801341687079081505L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobid;
	
	@NotEmpty
	@Column
	private String code;
	
	@NotEmpty
	@Column
	private String position;
	
	@NotEmpty
	@Column
	private String location;
	
	@NotEmpty
	@Column
	private String primaryskill;
	
	@Column
	private String secondaryskill;
	
	@Column
	private String otherskills;
	
	@NotEmpty
	@Column
	private String responsibilities;
	
	@NotEmpty
	@Column
	private String exp;
		
	@Column
	private String status;
	
	
	@Column
	private Date postedDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	private User user;


	private String jobApplyStatus;

	public Long getJobid() {
		return jobid;
	}


	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPrimaryskill() {
		return primaryskill;
	}


	public void setPrimaryskill(String primaryskill) {
		this.primaryskill = primaryskill;
	}


	public String getSecondaryskill() {
		return secondaryskill;
	}


	public void setSecondaryskill(String secondaryskill) {
		this.secondaryskill = secondaryskill;
	}


	public String getOtherskills() {
		return otherskills;
	}


	public void setOtherskills(String otherskills) {
		this.otherskills = otherskills;
	}


	public String getResponsibilities() {
		return responsibilities;
	}


	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getPostedDate() {
		return postedDate;
	}


	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getJobApplyStatus() {
		return jobApplyStatus;
	}


	public void setJobApplyStatus(String jobApplyStatus) {
		this.jobApplyStatus = jobApplyStatus;
	}
	
}
