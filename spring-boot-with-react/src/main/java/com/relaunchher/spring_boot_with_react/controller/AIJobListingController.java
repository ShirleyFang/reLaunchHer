package com.relaunchher.spring_boot_with_react.controller;

import com.relaunchher.spring_boot_with_react.dao.model.JobLevel;
import com.relaunchher.spring_boot_with_react.dao.model.JobListing;
import com.relaunchher.spring_boot_with_react.service.AIJobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recommended-job-listings")
public class AIJobListingController {

    private final AIJobListingService aiJobListingService;

    @Autowired
    public AIJobListingController(AIJobListingService aiJobListingService) {
        this.aiJobListingService = aiJobListingService;
    }

    @GetMapping
    public List<JobListing> getJobListings(Integer numPostings, String jobTitle, String jobLevel, Boolean remoteIsRequired, Boolean dayCareIsRequired) {
        List<JobListing> jobListings = this.aiJobListingService.getJobListings(numPostings, jobTitle, jobLevel, remoteIsRequired, dayCareIsRequired);
        this.printJobListings(jobListings);
        return jobListings;
    }

    private void printJobListings(List<JobListing> jobListings) {
        for (JobListing jobListing : jobListings) {
            System.out.println(jobListing);
        }
    }

}
