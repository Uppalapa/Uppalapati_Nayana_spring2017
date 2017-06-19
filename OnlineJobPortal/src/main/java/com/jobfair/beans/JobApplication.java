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

@Entity
@Table(name = "jobsapplication")
public class JobApplication implements Serializable {

	private static final long serialVersionUID = 467431929554008004L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long jobappid;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobid", nullable = false)
	private Job job;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	private User user;
	
	@Column
	private String status;

	public Long getJobappid() {
		return jobappid;
	}

	public void setJobappid(Long jobappid) {
		this.jobappid = jobappid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
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
		builder.append("JobApplication [jobappid=").append(jobappid)
				.append(", job=").append(job).append(", user=")
				.append(user).append("]");
		return builder.toString();
	}

}
