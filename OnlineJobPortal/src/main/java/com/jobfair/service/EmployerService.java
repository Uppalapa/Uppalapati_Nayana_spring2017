package com.jobfair.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jobfair.beans.Job;
import com.jobfair.beans.JobApplication;
import com.jobfair.beans.Review;
import com.jobfair.beans.User;
import com.jobfair.dao.AppliedJobDao;
import com.jobfair.dao.JobDao;
import com.jobfair.dao.ReviewDao;
import com.jobfair.dao.UserDao;

@Service
public class EmployerService {
		
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AppliedJobDao appliedJobDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	public boolean isJobCodeExists(final String code) {
		
		boolean jobExists  = false;
		
		Job existingJob =  jobDao.findByCode(code);
		
		if(existingJob != null) {
			
			jobExists = true; 
		}
		
		return jobExists;
	}
	
	public List<Job> saveJob(Job job) {
		
		User existingUser = getCurrentUserDtls();
		
		job.setPostedDate(new Date());
		job.setUser(existingUser);
		
		jobDao.save(job);
		
		List<Job> jobsList = new ArrayList<Job>(existingUser.getPostedJobs());
		
		return jobsList;
	}
	
	
	public List<Job> getAllJobs() {
		
		User user = getCurrentUserDtls();
	
		List<Job> jobsList = new ArrayList<Job>(user.getPostedJobs());
		
		return jobsList;
	}


	
	public Job getJob(final long jobId) {
		
		Job job = jobDao.findOne(jobId);
		
		return job;
	}
	
	public List<JobApplication> getAllApplicationsOfJob(final long jobId) {
		
		Job job = jobDao.findOne(jobId);
		
		List<JobApplication> jobAppsList = appliedJobDao.findByJob(job);
		
		return jobAppsList;
	}

	public JobApplication getJobApplication(final long jobAppId) {
		
		return appliedJobDao.findOne(jobAppId);
	}
	
	public List<Review> getReviewsOnMe() {
		
		User user = getCurrentUserDtls();
		
		return reviewDao.findByReviewon(user.getUserid());
	}
	

	private User getCurrentUserDtls() {
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user =  userDao.findByUsername(userDetails.getUsername());
		return user;
	}
}
