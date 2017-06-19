package com.jobfair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jobfair.beans.Job;
import com.jobfair.beans.JobApplication;
import com.jobfair.beans.Review;
import com.jobfair.service.EmployerService;
import com.jobfair.validators.JobValidator;

@Controller
@RequestMapping(value = "/emp")
public class EmployerController {
	
	@Autowired
	private JobValidator validator;
	
	@Autowired
	private EmployerService service;
		
	@RequestMapping(value = "/postJob", method = RequestMethod.GET)
	public ModelAndView postJob(@ModelAttribute Job job ) {
		
		
		return new ModelAndView("emp/postjob");
	}
	
	@RequestMapping(value = "/submitJob", method = RequestMethod.POST)
	public ModelAndView submitJob(@Valid @ModelAttribute Job job,  BindingResult result) {
		
		validator.validateHTMLSafe(job, result);
		
		if(service.isJobCodeExists(job.getCode())) {
			result.addError(new FieldError("job", "code", "Job Code already exists"));
		}
		
		if (result.hasErrors()) {
			
			return new ModelAndView("emp/postjob");
        } 
		
		List<Job> jobsList = service.saveJob(job);
				
		return new ModelAndView("emp/listjobs", "jobs", jobsList);
	}

	@RequestMapping(value = "/allJobs", method = RequestMethod.GET)
	public ModelAndView viewAllJobs() {
		
		
		List<Job> jobsList = service.getAllJobs();
				
		return new ModelAndView("emp/listjobs", "jobs", jobsList);
	}
	
	@RequestMapping(value = "/viewJob/{jobId}", method = RequestMethod.GET)
	public ModelAndView viewJob(@PathVariable("jobId") long jobId) {
		
		
		Job job = service.getJob(jobId);
				
		return new ModelAndView("emp/postjob", "job", job);
	}
	
	@RequestMapping(value = "/viewApplicants/{jobId}", method = RequestMethod.GET)
	public ModelAndView viewApplicants(@PathVariable("jobId") long jobId) {
		
		List<JobApplication> jobsList = service.getAllApplicationsOfJob(jobId);
		
		return new ModelAndView("emp/applications", "jobApps", jobsList);
		
	}
	
	@RequestMapping(value = "/viewApplication/{jobAppId}", method = RequestMethod.GET)
	public ModelAndView viewApplicantion(@PathVariable("jobAppId") long jobAppId) {
		
		JobApplication jobApp = service.getJobApplication(jobAppId);
		
		return new ModelAndView("emp/viewapplication", "jobApp", jobApp);
		
	}

	@RequestMapping(value = "/viewReviews", method = RequestMethod.GET)
	public ModelAndView viewReviews( ) {
		
		List<Review> reviewsList = service.getReviewsOnMe();
		
		return new ModelAndView("emp/reviews", "reviews", reviewsList);
		
	}
	
}
