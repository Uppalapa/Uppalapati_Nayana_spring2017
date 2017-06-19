package com.jobfair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfair.beans.Job;
import com.jobfair.beans.JobApplication;
import com.jobfair.beans.Review;
import com.jobfair.beans.User;
import com.jobfair.service.JobSeekerService;

@Controller
@RequestMapping(value = "/jobSeeker")
public class JobSeekerController {
	
	@Autowired
	private JobSeekerService service;
	
	@RequestMapping(value = "/allJobs", method = RequestMethod.GET)
	public ModelAndView viewAllJobs() {
		
		
		List<Job> jobsList = service.searchAllActiveJobs();
				
		return new ModelAndView("jobSeeker/listjobs", "jobs", jobsList);
	}
	
	@RequestMapping(value = "/viewJob/{jobId}", method = RequestMethod.GET)
	public ModelAndView viewJob(@PathVariable("jobId") long jobId) {
		
		
		Job job = service.getJob(jobId);
				
		return new ModelAndView("jobSeeker/viewjob", "job", job);
	}
	
	
	@RequestMapping(value = "/applyJob", method = RequestMethod.POST)
	public ModelAndView applyJob(@ModelAttribute Job job) {
		
		List<JobApplication> jobsList = service.applyJob(job.getJobid());
		
		System.out.println("applyJob resultset:"+jobsList);
				
		return new ModelAndView("jobSeeker/appliedjobs", "jobApps", jobsList);
	}
	
	
	
	@RequestMapping(value = "/viewAppliedJobs", method = RequestMethod.GET)
	public ModelAndView viewAppliedJobs() {
		
		List<JobApplication> jobsList = service.getAllAppliedJobs();
				
		return new ModelAndView("jobSeeker/appliedjobs", "jobApps", jobsList);
	}
	
	@RequestMapping(value = "/viewProfile/{userName}", method = RequestMethod.GET)
	public ModelAndView viewProfile(@PathVariable("userName") String userName) {
		
		User user = service.getUserProfile(userName);
					
		return new ModelAndView("jobSeeker/viewprofile", "user", user);
	}
	
	 
	@RequestMapping(value = "/addReview/{userName}", method = RequestMethod.GET)
	public ModelAndView addReview(@PathVariable("userName") String userName) {
		
		Review review = new Review();
		
		User user = service.getUserProfile(userName);
				
		review.setReviewon(user.getUserid());
		review.setEmpUserName(user.getUsername());
			
		return new ModelAndView("jobSeeker/addreview", "review", review);
	}

	@RequestMapping(value = "/submitReview", method = RequestMethod.POST)
	public ModelAndView submitReview(@Valid  @ModelAttribute Review review,  BindingResult result) {
		
		if (result.hasErrors()) {
			
			return new ModelAndView("jobSeeker/addreview");
        } 
		
		service.addReview(review);
		
		String msg= "Review added successfully.";
				
		return new ModelAndView("jobSeeker/success", "message", msg);
	}
	
	@RequestMapping(value = "/viewEmpPdf/{userName}", method = RequestMethod.GET)
    public ModelAndView  viewEmployerInPDF(@PathVariable("userName") String userName) {
                
		User emp = service.getUserProfile(userName);
		
       return new ModelAndView("pdfView", "user",  emp);
    }
	
}
