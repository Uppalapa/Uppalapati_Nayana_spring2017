package com.jobfair.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jobfair.beans.Job;
import com.jobfair.beans.JobApplication;
import com.jobfair.beans.User;

@Transactional
public interface AppliedJobDao extends CrudRepository<JobApplication, Long> {

	public List<JobApplication> findByUser(User userid);
	
	public List<JobApplication> findByJob(Job jobid);
	
	public JobApplication findByJobAndUser(Job jobid, User userid);
}
