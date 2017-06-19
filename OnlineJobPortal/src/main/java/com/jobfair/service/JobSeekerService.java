package com.jobfair.service;

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
public class JobSeekerService {

	@Autowired
	private JobDao jobDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AppliedJobDao appliedJobDao;
		
	@Autowired
	private ReviewDao reviewDao;

	public List<Job> searchAllActiveJobs() {

		List<Job> jobsList = jobDao.findByStatus("ACTIVE");
		
		return jobsList;
	}

	public Job getJob(final long jobId) {

		// Get the Job with requested jobId
		Job job = jobDao.findOne(jobId);
		
		// To check whether Job already applied by current user.
		
		// Get Current User
		User user = getCurrentUserDtls();
		
		// Fetch Job Application by both JobID & userID
		JobApplication jobApplication = appliedJobDao.findByJobAndUser(job, user);
		
		// If Job Already applied.
		if(jobApplication != null) {
			
			job.setJobApplyStatus(jobApplication.getStatus()); 
		}
		

		return job;
	}
	
	public User getUserProfile(final String userName) {
		
		return userDao.findByUsername(userName);
	}
	
	public List<JobApplication> applyJob(final long jobId) {
		
		 User user = getCurrentUserDtls();
		 
		 JobApplication appliedJob = new JobApplication();
		 
		 Job job = jobDao.findOne(jobId);
		 appliedJob.setJob(job);
		 appliedJob.setUser(user);
		 appliedJob.setStatus("APPLIED");
		 
		 appliedJobDao.save(appliedJob);
		 
		 List<JobApplication> appliedJobApps = appliedJobDao.findByUser(user);
		 
		 return appliedJobApps;
	}


	public List<JobApplication> getAllAppliedJobs() {
		
		 User user = getCurrentUserDtls();
		
		 List<JobApplication> appliedJobApps = appliedJobDao.findByUser(user);
			
		 
		return appliedJobApps;
	}
	
	public void addReview(Review review) {
		
		 User user = getCurrentUserDtls();
		 
		 review.setUserreviewed(user);
		 
		 reviewDao.save(review);
		
	}

	private User getCurrentUserDtls() {
		UserDetails userDetails =
				  (UserDetails)SecurityContextHolder.getContext().
				  getAuthentication().getPrincipal();
		 
		 User user = userDao.findByUsername(userDetails.getUsername());
		return user;
	}

}
