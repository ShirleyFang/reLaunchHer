    package com.relaunchher.spring_boot_with_react.service;

    import com.relaunchher.spring_boot_with_react.dao.model.JobLevel;
    import com.relaunchher.spring_boot_with_react.dao.model.JobListing;

    import java.util.List;

    public interface AIJobListingService {
        List<JobListing> getJobListings(Integer numPostings, String jobTitle, String jobLevel, Boolean remoteIsRequired, Boolean dayCareIsRequired);
    }
