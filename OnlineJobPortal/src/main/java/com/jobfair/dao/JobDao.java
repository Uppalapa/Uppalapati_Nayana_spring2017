package com.jobfair.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jobfair.beans.Job;

@Transactional
public interface JobDao extends CrudRepository<Job, Long> {

	public List<Job> findByStatus(String status);
	
	
	public List<Job> findByJobidIn(List<Long> jobidList);
	
	
	public Job findByCode(String code);
	
	
}
