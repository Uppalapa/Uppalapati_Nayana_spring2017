package com.jobfair.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

	private static final long serialVersionUID = -9155354305411485117L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewid;

	@Column
	private Long reviewon;
		
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	private User userreviewed;
	
	@NotEmpty
	@Range(min=1, max=10)
	@Column
	private String interviewrating;
	
	
	@NotEmpty
	@Range(min=1, max=10)
	@Column
	private String salaryrating;
	
	@NotEmpty
	@Range(min=1, max=10)
	@Column
	private String worklifebalance;
	
	
	@Column
	private String comments;
	
	
	private String empUserName;


	public Long getReviewid() {
		return reviewid;
	}

	public void setReviewid(Long reviewid) {
		this.reviewid = reviewid;
	}

	public Long getReviewon() {
		return reviewon;
	}


	public void setReviewon(Long reviewon) {
		this.reviewon = reviewon;
	}

	public User getUserreviewed() {
		return userreviewed;
	}


	public void setUserreviewed(User userreviewed) {
		this.userreviewed = userreviewed;
	}


	public String getInterviewrating() {
		return interviewrating;
	}


	public void setInterviewrating(String interviewrating) {
		this.interviewrating = interviewrating;
	}


	public String getSalaryrating() {
		return salaryrating;
	}


	public void setSalaryrating(String salaryrating) {
		this.salaryrating = salaryrating;
	}


	public String getWorklifebalance() {
		return worklifebalance;
	}


	public void setWorklifebalance(String worklifebalance) {
		this.worklifebalance = worklifebalance;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getEmpUserName() {
		return empUserName;
	}

	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}
	
	
	
}
